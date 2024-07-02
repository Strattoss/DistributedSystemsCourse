package sr.grpc.server;

import sr.grpc.gen.Offer;
import sr.grpc.gen.OfferFilter;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

public class SubscriptionInfo {
    private List<Offer> offersToConsider;
    private ClientSubscriptionHandler handler;
    private final OfferFilter offerFilter;
    private SubscriptionKiler killer;
    private final ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> clientSubscriptions;

    public SubscriptionInfo(
            ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> clientSubscriptions,
            List<Offer> offersToConsider,
            SubscriptionKiler killer,
            OfferFilter offerFilter) {
        this.clientSubscriptions = clientSubscriptions;
        this.offersToConsider = offersToConsider;
        this.killer = killer;
        this.offerFilter = offerFilter;
    }

    public List<Offer> getOffersToConsider() {
        return offersToConsider;
    }

    public ClientSubscriptionHandler getHandler() {
        return handler;
    }

    public ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> getClientSubscriptions() {
        return clientSubscriptions;
    }

    public SubscriptionKiler getKiller() {
        return killer;
    }

    public OfferFilter getOfferFilter() {
        return offerFilter;
    }

    public void setOffersToConsider(List<Offer> offersToConsider) {
        this.offersToConsider = offersToConsider;
    }

    public void setHandler(ClientSubscriptionHandler handler) {
        this.handler = handler;
    }

    public void setKiller(SubscriptionKiler killer) {
        this.killer = killer;
    }
}
