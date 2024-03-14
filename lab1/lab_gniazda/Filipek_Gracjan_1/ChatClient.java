import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9009;
    private static final int UDP_BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        System.out.println("### TCP/UDP CHAT CLIENT ###");
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DatagramSocket udpSocket = new DatagramSocket(socket.getLocalPort(), socket.getLocalAddress())) {
            System.out.println("Connected to the server at " + socket.getInetAddress() + ":" + socket.getPort());

            BufferedReader serverIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter serverOut = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("your nickname: ");
            String nickname = userInput.readLine();
            serverOut.println(nickname);

            Thread tcpReceivingThread = new Thread(() -> {
                try {
                    String message;
                    while ((message = serverIn.readLine()) != null) {
                        System.out.println(message);
                    }
                } catch (IOException e) {
                    System.out.println("The TCP connection with the server has been closed");
                }
            });
            tcpReceivingThread.start();

            Thread udpReceivingThread = new Thread(() -> {
                System.out.println("\nStart writing!");

                byte[] buffer = new byte[UDP_BUFFER_SIZE];

                try {
                    while (!Thread.currentThread().isInterrupted()) {
                        Arrays.fill(buffer, (byte) 0);
                        DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

                        udpSocket.receive(receivePacket);
                        System.out.println(new String(receivePacket.getData()));
                    }
                } catch (IOException e) {
                    System.out.println("Udp socket has been closed");
                }
            });
            udpReceivingThread.start();

            SendingThread sendingThread = new SendingThread(userInput, serverOut, udpSocket);
            sendingThread.start();

            // wait for server or user to close the connection
            tcpReceivingThread.join();

            udpReceivingThread.interrupt();
            sendingThread.interrupt();

            udpSocket.close();
            socket.close();

            udpReceivingThread.join();
            System.out.println("[press Enter to close]");
            sendingThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class SendingThread extends Thread {
        private final BufferedReader userInput;
        private final PrintWriter serverOut;
        private final DatagramSocket udpSocket;

        private static String asciiArt = "                              .... \r\n" + //
                "                           ,;;'''';;,                    ,;;;;, \r\n" + //
                "                 ,        ;;'      `;;,               .,;;;'   ; \r\n" + //
                "              ,;;;       ;;          `;;,';;;,.     ,%;;'     ' \r\n" + //
                "            ,;;,;;       ;;         ,;`;;;, `;::.  %%;' \r\n" + //
                "           ;;;,;;;       `'       ,;;; ;;,;;, `::,%%;' \r\n" + //
                "           ;;;,;;;,          .,%%%%%'% ;;;;,;;   %;;; \r\n" + //
                " ,%,.      `;;;,;;;,    .,%%%%%%%%%'%; ;;;;;,;;  %;;; \r\n" + //
                ";,`%%%%%%%%%%`;;,;;'%%%%%%%%%%%%%'%%'  `;;;;;,;, %;;; \r\n" + //
                ";;;,`%%%%%%%%%%%,; ..`%%%%%%%%;'%%%'    `;;;;,;; %%;; \r\n" + //
                " `;;;;;,`%%%%%,;;/, .. `\"\"\"'',%%%%%      `;;;;;; %%;;, \r\n" + //
                "    `;;;;;;;,;;/////,.    ,;%%%%%%%        `;;;;,`%%;; \r\n" + //
                "           ;;;/%%%%,%///;;;';%%%%%%,          `;;;%%;;, \r\n" + //
                "          ;;;/%%%,%%%%%/;;;';;'%%%%%,             `%%;; \r\n" + //
                "         .;;/%%,%%%%%//;;'  ;;;'%%%%%,             %%;;, \r\n" + //
                "         ;;//%,%%%%//;;;'   `;;;;'%%%%             `%;;; \r\n" + //
                "         ;;//%,%//;;;;'      `;;;;'%%%              %;;;, \r\n" + //
                "         `;;//,/;;;'          `;;;'%%'              `%;;; \r\n" + //
                "           `;;;;'               `;'%'                `;;;; \r\n" + //
                "                                  '      .,,,.        `;;;; \r\n" + //
                "                                      ,;;;;;;;;;;,     `;;;; \r\n" + //
                "                                     ;;;'    ;;;,;;,    `;;;; \r\n" + //
                "                                     ;;;      ;;;;,;;.   `;;;; \r\n" + //
                "                                      `;;      ;;;;;,;;   ;;;; \r\n" + //
                "                                        `'      `;;;;,;;  ;;;; \r\n" + //
                "                                                   `;;,;, ;;;; \r\n" + //
                "                                                      ;;, ;;;; \r\n" + //
                "                                                        ';;;;; \r\n" + //
                "                                                         ;;;;; \r\n" + //
                "                                                        .;;;;' \r\n" + //
                "                                                       .;;;;' \r\n" + //
                "                                                      ;;;;;' \r\n" + //
                "                                                     ,;;;;'";

        public SendingThread(BufferedReader userInput, PrintWriter serverOut, DatagramSocket udpSocket) {
            this.userInput = userInput;
            this.serverOut = serverOut;
            this.udpSocket = udpSocket;
        }

        public void run() {
            try {
                String userMessage;
                while (!Thread.currentThread().isInterrupted() && (userMessage = userInput.readLine()) != null) {
                    String strippedMessage = userMessage.strip();
                    if (strippedMessage.equals(""))
                        continue;
                    if (strippedMessage.toUpperCase().equals("U")) {
                        this.sendAsciiArtWithUdp();
                        continue;
                    }
                    serverOut.println(userMessage);
                }
            } catch (IOException e) {
                System.out.println("User input has been closed");
            }

            System.out.println("User input sending thread has ended");
        }

        private void sendAsciiArtWithUdp() {
            try (Scanner ascii = new Scanner(asciiArt)) {
                while (ascii.hasNextLine()) {
                    byte[] buffer = ascii.nextLine().getBytes();
                    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length,
                            InetAddress.getByName(SERVER_ADDRESS), SERVER_PORT);

                    this.udpSocket.send(datagramPacket);
                    // uncomment to see more stream-like transmision
                    // sleep(50); 
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
