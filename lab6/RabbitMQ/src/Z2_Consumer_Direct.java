import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Z2_Consumer_Direct {
    public static void main(String[] argv) throws Exception {

        // info
        System.out.println("Z2 CONSUMER DIRECT");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
        String EXCHANGE_DIRECT_NAME = "direct";
        channel.exchangeDeclare(EXCHANGE_DIRECT_NAME, BuiltinExchangeType.DIRECT);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter routing key: ");
        String key = br.readLine();

        // queue & bind
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_DIRECT_NAME, key);
        System.out.println("created queue: " + queueName);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received: " + message);
            }
        };

        // start listening
        System.out.println("Waiting for messages...");
        channel.basicConsume(queueName, true, consumer);
    }
}
