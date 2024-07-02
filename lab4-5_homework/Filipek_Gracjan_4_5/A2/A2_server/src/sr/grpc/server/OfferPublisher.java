package sr.grpc.server;

import sr.grpc.gen.Offer;
import sr.grpc.gen.SubscribeResponse;

import java.util.ArrayList;
import java.util.List;

public class OfferPublisher {
    private static OfferPublisher instance;
    private final List<List<Offer>> queues;

    private OfferPublisher() {
        queues = new ArrayList<>();
    }

    public static synchronized OfferPublisher getInstance() {
        if (instance == null) {
            instance = new OfferPublisher();
        }
        return instance;
    }

    public synchronized void registerQueue(List<Offer> queue) {
        queues.add(queue);
    }

    public synchronized void deregisterQueue(List<Offer> queue) {
        queues.remove(queue);
    }

    public synchronized void publishOffer() {
        Offer newOffer = RandomOfferGenerator.generateOffer();
        System.out.println("Offer generated with id: " + newOffer.getOfferId());
        for (var queue : queues) {
            synchronized (queue) {
                queue.add(newOffer);
                queue.notifyAll();
            }
        }
    }
}
