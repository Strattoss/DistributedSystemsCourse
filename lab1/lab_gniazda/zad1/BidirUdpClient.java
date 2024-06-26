import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class BidirUdpClient {

    public static void main(String args[]) throws Exception
    {
        System.out.println("JAVA UDP CLIENT");
        DatagramSocket socket = null;
        int portNumber = 9008;

        byte[] sendBuffer = "Ping Java Udp".getBytes();
        byte[] receiveBuffer = new byte[1024];

        try {
            Arrays.fill(receiveBuffer, (byte)0);
            
            socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("localhost");

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, address, portNumber);
            socket.send(sendPacket);

            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            socket.receive(receivePacket);

            System.out.println("received msg: " + new String(receivePacket.getData()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}
