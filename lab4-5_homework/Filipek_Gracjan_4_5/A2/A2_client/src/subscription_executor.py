import threading
from threading import Thread

import grpc
import src.subscribing_pb2 as pb
import src.subscribing_pb2_grpc as pb_grpc

# TODO: If I had more time, I would make it possible for the user to retrieve streams just with user id.
#  Something like "getAllMySubscriptions"


class SubscriptionExecutor(Thread):
    def __init__(self, stub, user_id: int, subscription_id: int):
        super().__init__()

        self.stub = stub
        self.response_generator: grpc.Future | None = None
        self.user_id = user_id
        self.subscription_id = subscription_id

    def run(self):
        try:
            request = pb.SubscribeRequest(user_id=self.user_id, subscription_id=self.subscription_id)
            self.response_generator = self.stub.Subscribe(request)
            for response in self.response_generator:
                print_offert_details(response.offer, self.subscription_id)
            print(f"Subscription on thread {threading.current_thread().name} discontinued")
        except grpc.RpcError as e:
            print("RPC failed: ", e)
            print(f"Cancelling subscription on thread {threading.current_thread().name}...")
            # if e.code() in [grpc.StatusCode.FAILED_PRECONDITION]:
            #     print(f"Removing thread {threading.current_thread().name} from the list")
            #     self.executors.remove(self)

        print(f"Subscription {threading.current_thread().name} finally ended\n")

    def interrupt(self):
        if self.response_generator and not self.response_generator.cancelled():
            self.response_generator.cancel()


def print_offert_details(offer: pb.Offer, subscription_id: int):
    print(f"New offer! \n"
          f"\tsubscription_id: {subscription_id}, \n"
          f"\tthread_id: {threading.current_thread().name}, \n"
          f"\toffer_id: {offer.offer_id}, \n"
          f"\ttitle: {offer.title}, \n"
          f"\tcategory: {pb.Category.keys()[offer.category]}, \n"
          f"\tdescription: {offer.description}, \n"
          f"\tprice_integer_part: {offer.price_integer_part}, \n"
          f"\tprice_decimal_part: {offer.price_decimal_part}, \n"
          f"\tavailable_amount: {offer.available_amount}"
          )