from src import subscribing_pb2 as pb
from src import subscribing_pb2_grpc as pb_grpc

def read_offer_filter_from_user():
    offer_filter = pb.OfferFilter()

    print("[f] Press Enter at any time to skip a field")

    print(f"[f] Available categories: {pb.Category.keys()}")
    while True:
        print(f"[f] Chosen categories: {offer_filter.categories}")
        category_input = input("[f] Enter category name (press Enter to stop): ")
        if not category_input:
            break
        if category_input not in pb.Category.keys():
            print(f"[f] There is no category {category_input}.")
            continue
        offer_filter.categories.append(category_input)

    minimal_price_input = input("[f] Enter minimal price (optional): ")
    if minimal_price_input:
        offer_filter.minimalPrice = float(minimal_price_input)

    maximal_price_input = input("[f] Enter maximal price (optional): ")
    if maximal_price_input:
        offer_filter.maximalPrice = float(maximal_price_input)

    minimal_available_amount_input = input("[f] Enter minimal available amount (optional): ")
    if minimal_available_amount_input:
        offer_filter.minimalAvailableAmount = int(minimal_available_amount_input)

    maximal_available_amount_input = input("[f] Enter maximal available amount (optional): ")
    if maximal_available_amount_input:
        offer_filter.maximalAvailableAmount = int(maximal_available_amount_input)

    return offer_filter
