import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Z1_Producer {

    public static void main(String[] argv) throws Exception {

        // info
        System.out.println("Z1 PRODUCER");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // queue
        String QUEUE_NAME = "queue1";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("x")) break;
            channel.basicPublish("", QUEUE_NAME, null, line.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent: " + line);
        }

        // producer (publish msg)
        String message = "Hello world!";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
        System.out.println("Sent: " + message);

        // close
        channel.close();
        connection.close();
    }
}