package sr.grpc.server;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        final String address = "127.0.0.5";
        final int port = 50051;

        final GrpcServer server = new GrpcServer(address, port);
        server.start();

        new Thread() {
            public void run() {
                OfferPublisher publisher = OfferPublisher.getInstance();
                while (true) {
                    publisher.publishOffer();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        server.blockUntilShutdown();
    }
}
