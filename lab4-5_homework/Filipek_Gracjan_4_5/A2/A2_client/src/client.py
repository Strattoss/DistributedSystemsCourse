import grpc

import src.subscribing_pb2 as pb
import src.subscribing_pb2_grpc as pb_grpc
from src.subscription_executor import SubscriptionExecutor
from src.utils import read_offer_filter_from_user


class GrpcClient:
    channel_options = [
        ("grpc.keepalive_time_ms", 5000)
        # Now, even if NAT or PAT translation expires / breaks down,
        # the client will ping to keep it alive alive / recreate one
    ]

    def __init__(self, remote_host, remote_port, user_id):
        self.remote_host = remote_host
        self.remote_port = remote_port
        self.user_id = user_id
        self.channel = None
        self.stub = None
        self.subscription_ids: list[int] = []
        self.executors: dict[int, SubscriptionExecutor] = {}

        self.setUpConnection()

    def setUpConnection(self):
        self.channel = grpc.insecure_channel(
            target=f"{self.remote_host}:{self.remote_port}",
            options=self.channel_options)
        self.stub = pb_grpc.OfferObservableStub(self.channel)

    def run_cli(self):
        line = None
        try:
            while line != "x":
                print("==> ", end="", flush=True)
                line = input()

                if line == "ls":
                    self.list_subscriptions()
                elif line == "rm":
                    self.remove_subscription()
                elif line == "new sub":
                    self.create_new_subscription()
                elif line == "sub":
                    self.connect_to_subscription()
                elif line == "retry":
                    self.retry_subscriptions()
                elif line in ("x", ""):
                    pass
                else:
                    print("???")
        except KeyboardInterrupt:
            pass
        finally:
            self.__shutdown()

    def list_subscriptions(self):
        print("Active subscriptions/threads I have created during this session:")
        for subscription_id in self.subscription_ids:
            print(f"\tsubscription_id: {subscription_id},"
                  f"\texecutor: {self.executors.get(subscription_id, None)}")

    def remove_subscription(self):
        try:
            subscription_id = int(input("Enter subscription id: "))
            self.subscription_ids.remove(subscription_id)

            executor = self.executors.get(subscription_id, None)
            if executor is not None:
                executor.interrupt()
            self.executors.pop(subscription_id, None)
        except ValueError:
            print("Invalid subscription id")

    def retry_subscriptions(self):
        print(f"Trying to reconnect for subscriptions: {self.subscription_ids}")
        self.setUpConnection()
        for subscription_id in self.subscription_ids:
            if self.executors[subscription_id].is_alive():
                print(f"Cannot retry for subscription {subscription_id}"
                      f", because there is an active executor")
                continue
            self.__run_subscription_executor(subscription_id)

    def connect_to_subscription(self):
        try:
            subscription_id = int(input("Enter subscription id: "))
            self.__run_subscription_executor(subscription_id)
        except ValueError:
            print("Invalid subscription id")

    def create_new_subscription(self):
        print(f"Creating new subscription")
        offer_filter = None
        if input("Do you want to include a filter? (y/n)") == "y":
            offer_filter = read_offer_filter_from_user()
        request = pb.CreateSubscriptionRequest(user_id=self.user_id, offer_filter=offer_filter)
        try:
            response: pb.CreateSubscriptionResponse = self.stub.CreateSubscription(request)
            self.subscription_ids.append(response.subscription_id)
            print(f"Subscription created. Id: {response.subscription_id}")
        except grpc.RpcError as e:
            print("RPC failed: ", e)

    def __run_subscription_executor(self, subscription_id):
        executor = SubscriptionExecutor(self.stub, self.user_id, subscription_id)
        self.executors[subscription_id] = executor
        executor.start()

    def __shutdown(self):
        for executor in self.executors.values():
            executor.interrupt()
        for executor in self.executors.values():
            executor.join()
        print("Client shutting down")
        self.channel.close()
