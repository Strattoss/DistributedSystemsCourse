package sr.grpc.server;

import sr.grpc.gen.Offer;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionIdGenerator {
    private static SubscriptionIdGenerator instance;
    private int lastSubscriptionId = 1;

    private SubscriptionIdGenerator() {
    }

    public static synchronized SubscriptionIdGenerator getInstance() {
        if (instance == null) {
            instance = new SubscriptionIdGenerator();
        }
        return instance;
    }

    public synchronized int getNextSubscriptionId() {
        return lastSubscriptionId++;
    }
}
