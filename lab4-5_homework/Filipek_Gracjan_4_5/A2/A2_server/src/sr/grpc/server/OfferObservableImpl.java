package sr.grpc.server;

import io.grpc.Status;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;
import jdk.jshell.execution.Util;
import sr.grpc.gen.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OfferObservableImpl extends OfferObservableGrpc.OfferObservableImplBase {
    private static final ConcurrentMap<Integer, ConcurrentMap<Integer, SubscriptionInfo>> clientsSubscriptions = new ConcurrentHashMap<>();

    @Override
    public void createSubscription(CreateSubscriptionRequest request, StreamObserver<CreateSubscriptionResponse> responseObserver) {
        Utils.printInfo("Create subscription request started", request.getUserId());

        clientsSubscriptions.putIfAbsent(
                request.getUserId(),
                new ConcurrentHashMap<>()
        );
        var subscriptions = clientsSubscriptions.get(request.getUserId());
        int subscriptionId = SubscriptionIdGenerator.getInstance().getNextSubscriptionId();

        // create and register the subscription queue
        List<Offer> offersToConsider = Collections.synchronizedList(new LinkedList<>());
        OfferPublisher.getInstance().registerQueue(offersToConsider);

        // set up a killer that will tidy up if the user doesn't subscribe to the subscription
        var killer = new SubscriptionKiler(10000, subscriptions, subscriptionId, request.getUserId(), null);
        killer.start();

        var info = new SubscriptionInfo(clientsSubscriptions, offersToConsider, killer, request.getOfferFilter());

        subscriptions.put(subscriptionId, info);

        var response = CreateSubscriptionResponse.newBuilder()
                .setSubscriptionId(subscriptionId)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();

        Utils.printInfo("Create subscription request ended", request.getUserId());
    }

    @Override
    public void subscribe(SubscribeRequest request, StreamObserver<SubscribeResponse> responseObserver) {
        Utils.printInfo("Subscription request started", request.getUserId(), request.getSubscriptionId());

        var subscriptions = clientsSubscriptions.get(request.getUserId());
        if (subscriptions == null) {
            var description = "There is no user with id: " + request.getUserId();
            responseObserver.onError(Status.FAILED_PRECONDITION
                    .withDescription(description)
                    .asRuntimeException());
            Utils.printInfo("Subscription request failed. Reason: " + description
                    , request.getUserId()
                    , request.getSubscriptionId());
            return;
        }

        var subscriptionInfo = subscriptions.get(request.getSubscriptionId());
        if (subscriptionInfo == null) {
            var description = "There is no subscription with id: "
                    + request.getSubscriptionId()
                    + ". Perhaps it has expired?";
            responseObserver.onError(Status.FAILED_PRECONDITION
                    .withDescription(description)
                    .asRuntimeException());
            Utils.printInfo("Subscription request failed. Reason: " + description,
                    request.getUserId(),
                    request.getSubscriptionId());
            return;
        }

        // don't kill the subscription: user has started listening
        subscriptionInfo.getKiller().interrupt();

        ClientSubscriptionHandler handler =
                new ClientSubscriptionHandler(
                        request.getUserId(),
                        request.getSubscriptionId(),
                        clientsSubscriptions,
                        subscriptionInfo.getOffersToConsider(),
                        subscriptionInfo.getOfferFilter()
                        );

        var castedStreamObserver = ((ServerCallStreamObserver<SubscribeResponse>)responseObserver);
        handler.setUpSubscription(castedStreamObserver);
        handler.start();

        Utils.printInfo("Start subscription request ended",
                request.getUserId(),
                request.getSubscriptionId());
    }
}


