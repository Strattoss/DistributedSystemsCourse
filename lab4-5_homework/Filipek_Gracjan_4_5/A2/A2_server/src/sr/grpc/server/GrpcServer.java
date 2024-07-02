package sr.grpc.server;

import io.grpc.Server;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class GrpcServer {
    private static final Logger logger = Logger.getLogger(GrpcServer.class.getName());
    final private Server server;

    public GrpcServer(String address, int port) throws UnknownHostException {

        SocketAddress socket = new InetSocketAddress(InetAddress.getByName(address), port);

        server = NettyServerBuilder.forAddress(socket).executor(Executors.newFixedThreadPool(16))
                .addService(new OfferObservableImpl())
                // it looks like I cannot set any number under 10 seconds??
                .keepAliveTime(20, TimeUnit.SECONDS) // FOr detecting dead / muted clients
                .permitKeepAliveTime(5, TimeUnit.SECONDS) // If a client pings more than once every 5 seconds, terminate the connection.
                .build();

        logger.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                System.err.println("Shutting down gRPC server...");
                GrpcServer.this.stop();
                System.err.println("Server shut down.");
            }
        });
    }

    void start() throws IOException
    {
        server.start();
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }
}
