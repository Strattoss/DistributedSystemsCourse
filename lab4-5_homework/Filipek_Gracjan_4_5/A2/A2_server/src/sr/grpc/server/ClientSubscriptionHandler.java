package sr.grpc.server;

import io.grpc.stub.ServerCallStreamObserver;
import sr.grpc.gen.Offer;
import sr.grpc.gen.OfferFilter;
import sr.grpc.gen.SubscribeResponse;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class ClientSubscriptionHandler extends Thread {
    final private int userId;
    final private int subscriptionId;
    private ServerCallStreamObserver<SubscribeResponse> responseObserver;
    final private List<Offer> offersToConsider;
    final private OfferFilter offerFilter;
    private final ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> clientSubscriptions;

    private int lastResponseId = 1;

    public ClientSubscriptionHandler(
            int userId,
            int subscriptionId,
            ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> clientSubscriptions,
            List<Offer> offersToConsider,
            OfferFilter offerFilter) {
        super();

        this.userId = userId;
        this.subscriptionId = subscriptionId;
        this.clientSubscriptions = clientSubscriptions;
        this.offersToConsider = offersToConsider;
        this.offerFilter = offerFilter;
    }

    public void setUpSubscription(ServerCallStreamObserver<SubscribeResponse> responseObserver) {
        this.responseObserver = responseObserver;
        this.responseObserver.setOnCancelHandler(this::onCancelHandler);
    }

    @Override
    public void run() {
        // We use the tmp list of offers, so we don't occupy the synchronized block for too long;
        // we just make a copy, leave the synchronized block and perform necessary operations using the copy
        List<Offer> tmpOffersToConsider;
        while (true) {
            synchronized (offersToConsider) {
                tmpOffersToConsider = List.copyOf(offersToConsider);
                offersToConsider.clear();
            }

            for (Offer offer : tmpOffersToConsider) {
                if (!OfferFilterMatcher.matches(offerFilter, offer)) continue;
                var response = SubscribeResponse
                        .newBuilder()
                        .setResponseId(lastResponseId++)
                        .setSubscriptionId(subscriptionId)
                        .setOffer(offer)
                        .build();

                if (Thread.currentThread().isInterrupted()) break;
                responseObserver.onNext(response);
            }

            synchronized (offersToConsider) {
                try {
                    offersToConsider.wait();
                } catch (InterruptedException e) {
                    Utils.printInfo("Thread was interrupted", userId, subscriptionId);
                    break;
                }
            }
        }

        Utils.printInfo("Thread has been ended", userId, subscriptionId);
    }


    private void onCancelHandler() {
        Utils.printInfo("OnCancelHandle invoked", userId, subscriptionId);
        var userSubscriptions = clientSubscriptions.get(userId);
        if (userSubscriptions == null) return;

        var thisSubscriptionInfo = userSubscriptions.get(subscriptionId);
        if (thisSubscriptionInfo == null) return;

        SubscriptionKiler killer = new SubscriptionKiler(30000, userSubscriptions, subscriptionId, userId, null);
        thisSubscriptionInfo.setKiller(killer);
        killer.start();

        this.interrupt();
        Utils.printInfo("OnCancelHandle ended", userId, subscriptionId);
    }
}
