import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Z2_Producer {

    public static void main(String[] argv) throws Exception {

        // info
        System.out.println("Z2 PRODUCER");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        final String EXCHANGE_DIRECT_NAME = "direct";
        final String EXCHANGE_TOPIC_NAME = "topic";
        channel.exchangeDeclare(EXCHANGE_DIRECT_NAME, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(EXCHANGE_TOPIC_NAME, BuiltinExchangeType.TOPIC);

        while (true) {

            // read msg
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter message: ");
            String message = br.readLine();

            System.out.println("Enter routing key: ");
            String key = br.readLine();

            // break condition
            if ("exit".equals(message)) {
                break;
            }

            // publish
            channel.basicPublish(EXCHANGE_DIRECT_NAME, key, null, message.getBytes(StandardCharsets.UTF_8));
            channel.basicPublish(EXCHANGE_TOPIC_NAME, key, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Sent: " + message);
        }
    }
}
