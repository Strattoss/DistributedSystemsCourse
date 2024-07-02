from src.client import GrpcClient


def main():
    remote_host = "127.0.0.5"
    remote_port = 50051
    print("Your user id (uint): ", end="")
    user_id = int(input())
    client = GrpcClient(remote_host, remote_port, user_id)
    client.run_cli()

if __name__ == "__main__":
    main()