import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int SERVER_PORT = 9009;
    private static final int UDP_BUFFER_SIZE = 1024;
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final Set<TcpClientHandlingThread> clientHandlers = ConcurrentHashMap.newKeySet();

    public static void main(String[] args) throws IOException {
        System.out.println("### TCP/UDP CHAT SERVER ###");

        try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
                DatagramSocket datagramSocket = new DatagramSocket(SERVER_PORT)) {

            UdpHandlingThread udpHandler = new UdpHandlingThread(datagramSocket);
            executorService.submit(udpHandler);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("new client connected at port " + clientSocket.getPort());

                TcpClientHandlingThread handler = new TcpClientHandlingThread(clientSocket);
                executorService.submit(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static public class UdpHandlingThread extends Thread {
        private final DatagramSocket datagramSocket;

        public UdpHandlingThread(DatagramSocket datagramSocket) {
            this.datagramSocket = datagramSocket;
        }

        public void run() {
            byte[] buffer = new byte[UDP_BUFFER_SIZE];
            while (true) {
                Arrays.fill(buffer, (byte) 0);
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                try {
                    this.datagramSocket.receive(receivePacket);
                    this.broadcast(buffer, receivePacket.getSocketAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void broadcast(byte[] bytes, SocketAddress senderAddress) {
            try {
                for (TcpClientHandlingThread clientHandler : clientHandlers) {
                    if (clientHandler.clientSocket.getRemoteSocketAddress().equals(senderAddress))
                        continue;
                    InetAddress clientAddress = clientHandler.clientSocket.getInetAddress();
                    int clientPort = clientHandler.clientSocket.getPort();
                    DatagramPacket sendPacket = new DatagramPacket(bytes, bytes.length, clientAddress, clientPort);

                    this.datagramSocket.send(sendPacket);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public class TcpClientHandlingThread extends Thread {
        private final Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private String nickname;

        public TcpClientHandlingThread(Socket clientSocket) {
            this.clientSocket = clientSocket;

        }

        private boolean init() {
            try {
                this.out = new PrintWriter(clientSocket.getOutputStream(), true);
                this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // read client's nick
                this.nickname = in.readLine();
                System.out.println(
                        "client at port " + this.clientSocket.getPort() + " chose their nickname: " + this.nickname);
            } catch (Exception e) {
                try {
                    this.clientSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                System.out.println("client at port " + this.clientSocket.getPort()
                        + " disconnected before choosing their nickname");
                return false;
            }
            return true;
        }

        public void run() {
            boolean initSuccessful = init();
            if (!initSuccessful)
                return;

            clientHandlers.add(this);
            this.broadcastMessage("[server] user " + this.nickname + " has entered the chat");

            try (this.clientSocket) {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("received message from [" + nickname + "]: " + message);
                    this.broadcastMessage(String.format("[%s] %s", this.nickname, message));
                }
            } catch (IOException e) {
                System.out.println("connection with [" + this.nickname + "] has been ended");
            } finally {
                clientHandlers.remove(this);
            }
            this.broadcastMessage("[server] user " + this.nickname + " has left the chat");
        }

        public void broadcastMessage(String msg) {
            for (TcpClientHandlingThread clientHandlingThread : clientHandlers) {
                if (clientHandlingThread == this)
                    continue;
                clientHandlingThread.out.println(msg);;
            }
        }
    }
}
