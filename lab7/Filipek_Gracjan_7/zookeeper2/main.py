from kazoo.client import KazooClient
from kazoo.exceptions import NoNodeError
from kazoo.recipe.watchers import ChildrenWatch, DataWatch
import subprocess
import os
import sys


def download_tree(zk: KazooClient, root_path: str) -> dict[str, set[str]]:
    znode_children = dict()

    def rec(path: str):
        children = zk.get_children(path)
        znode_children[path] = set(children)
        for child in children:
            child_path = f"{path}/{child}"
            rec(child_path)

    rec(root_path)
    return znode_children


class ZooKeeperApp:
    def __init__(self, kazoo_client: KazooClient, znode_path: str, external_app_path: str):
        self.zk = kazoo_client
        self.znode_path = znode_path
        self.external_app_path = external_app_path
        self.external_app_process = None
        self.children: dict[str, set[str]] = {}

    def run(self):
        self.zk.start()
        print("Zookeeper client running")

        # TODO: is it really necessary?
        if self.zk.exists(self.znode_path):
            print(f"Znode at '{self.znode_path}' already exists")
            self.run_external_app()
            self.children = download_tree(self.zk, self.znode_path)

        # react when znode at `znode_path` is created or deleted
        @self.zk.DataWatch(self.znode_path)
        def watch_node(data, stat, event):
            if event:
                if event.type == "CREATED":
                    print(f"Znode at '{self.znode_path}' has been created.\n    Opening the app...")
                    self.run_external_app()
                elif event.type == "DELETED":
                    print(f"Znode at '{self.znode_path}' has been deleted.\n    Closing the app...")
                    self.stop_external_app()

        self.apply_watches_recursively(self.znode_path)

        print("Entering the main loop")
        try:
            while True:
                line = input(">>")
                if line == "t" or line == "tree":
                    self.display_tree()
                elif line == "c" or line == "count":
                    self.display_descendants_count()
                elif line == "h" or line == "help":
                    print("Available commands: tree|t, count|c, help|h, quit|q")
                elif line == "":
                    pass
                elif line == "q" or line == "q":
                    break
                else:
                    print("Unknown command")
        finally:
            self.zk.stop()

    def run_external_app(self):
        if self.external_app_process is None:
            self.external_app_process = subprocess.Popen(self.external_app_path)

    def stop_external_app(self):
        if self.external_app_process is not None:
            self.external_app_process.terminate()
            self.external_app_process = None


    def apply_watches_recursively(self, path_root: str):
        # when children of a node which is being observed change, this function gets triggered
        def get_watch_node_children(path: str):
            def watch_node_children(children):
                # print(f"w_n_children for {path}")

                new_children = set(children)
                old_children = self.children[path]
                self.children[path] = new_children

                added_children = new_children.difference(old_children)
                removed_children = old_children.difference(new_children)

                if len(removed_children) > 0:
                    print(f"Child {removed_children} has been removed from '{path}'")
                    self.display_descendants_count()
                    return

                elif len(added_children) > 0:
                    print(f"Child {added_children} has been created at '{path}'")
                    for child in added_children:
                        child_path = f"{path}/{child}"
                        self.children[child_path] = set()
                        ChildrenWatch(self.zk, child_path, func=get_watch_node_children(child_path))
                    self.display_descendants_count()

                else:  # first runthrough, init
                    for child in children:
                        child_path = f"{path}/{child}"
                        ChildrenWatch(self.zk, child_path, func=get_watch_node_children(child_path))

            return watch_node_children

        # this function gets triggerd when the root node gets deleted or created; applies only to the root node
        @DataWatch(self.zk, self.znode_path)
        def watch_root_node_deletion_and_creation(data, stat, event):
            # print(f"w_n_deletion for {path}")
            if event and event.type == "DELETED":
                print(f"Znode {event.path} has been deleted")
                self.display_descendants_count()
            if event and event.type == "CREATED":
                print(f"Znode {event.path} has been created")
                self.children[self.znode_path] = set()
                ChildrenWatch(self.zk, self.znode_path, func=get_watch_node_children(self.znode_path))

        ChildrenWatch(self.zk, path_root, func=get_watch_node_children(path_root))

    def display_descendants_count(self):
        print("Displaying descendant count...")
        def rec(path):
            try:
                children = self.zk.get_children(path)

                if children is None:
                    return 0
                descendants_count = len(children)

                for child in children:
                    child_path = f"{path}/{child}"
                    descendants_count += rec(child_path)
            except NoNodeError:
                print(f"    Node '{path}' doesn't exist")
                return None

            return descendants_count

        descendants_count = rec(self.znode_path)
        if descendants_count != None:
            print(f"    Znode '{self.znode_path}' has {descendants_count} descendants")

    def display_tree(self):
        print("Displaying tree...")
        def rec(path, indent_width=0):
            try:
                children = self.zk.get_children(path)
                print(f"{indent_width * '    '}{os.path.basename(path)}")
                for child in children:
                    rec(f"{path}/{child}", indent_width + 1)
            except NoNodeError:
                print(f"    Node '{path}' doesn't exist")

        rec(self.znode_path, 0)


if __name__ == "__main__":
    if len(sys.argv) < 4:
        print("Usage: python main.py <ZooKeeperHostIP>:<port> <NodePathToWatch> <ExternalAppPath>")
        print("Example: python main.py 127.0.0.1:2181 /a mspaint")
        sys.exit(1)

    host_addr = sys.argv[1]
    znode_path = sys.argv[2]
    external_app_path = sys.argv[3]

    if not os.path.isabs(znode_path):
        print(f"'{znode_path}' is an incorrect path. It cannot identify a znode")
        sys.exit(1)

    kazoo_client = KazooClient(hosts=host_addr)

    app = ZooKeeperApp(kazoo_client, znode_path, external_app_path)
    app.run()
