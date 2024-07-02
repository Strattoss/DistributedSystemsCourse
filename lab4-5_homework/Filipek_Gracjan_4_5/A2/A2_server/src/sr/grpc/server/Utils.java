package sr.grpc.server;

public class Utils {
    public static void printInfo(String string, int userId, int subscriptionId) {
        System.out.println("[u:" + userId + ", s:" + subscriptionId + "] " + string);
    }

    public static void printInfo(String string, int userId) {
        System.out.println("[u:" + userId + "] " + string);
    }
}
