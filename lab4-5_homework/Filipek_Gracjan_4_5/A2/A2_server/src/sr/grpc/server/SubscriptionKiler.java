package sr.grpc.server;

import java.util.concurrent.ConcurrentMap;

public class SubscriptionKiler extends Thread {
    private final int milis;
    private final ConcurrentMap<Integer, SubscriptionInfo> clientSubscriptions;
    private final ClientSubscriptionHandler handler;
    private final int subscriptionId;
    private final int userId;

    public SubscriptionKiler(
            int milis,
            ConcurrentMap<Integer, SubscriptionInfo> clientSubscriptions,
            int subscriptionId,
            int userId,
            ClientSubscriptionHandler handler) {
        this.milis = milis;
        this.clientSubscriptions = clientSubscriptions;
        this.handler = handler;
        this.subscriptionId = subscriptionId;
        this.userId = userId;
    }

    @Override
    public void run() {
        super.run();
        try {
            Utils.printInfo("Killing daemon started", userId, subscriptionId);
            sleep(milis);
            killAndTidyUp();
        } catch (InterruptedException e) {
            Utils.printInfo("Killing daemon cancelled", userId, subscriptionId);
        }
    }

    private void killAndTidyUp() {
        var subscriptionInfo = clientSubscriptions.get(subscriptionId);
        if (subscriptionInfo == null) return;

        synchronized (subscriptionInfo.getOffersToConsider()) {
            OfferPublisher.getInstance().deregisterQueue(subscriptionInfo.getOffersToConsider());
        }

        var handler = subscriptionInfo.getHandler();
        if (handler != null) handler.interrupt();

        clientSubscriptions.remove(subscriptionId);

        Utils.printInfo("Subscription killed and tidied up", userId, subscriptionId);
    }
}
