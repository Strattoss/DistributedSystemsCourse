import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Z1_Consumer {

    public static void main(String[] argv) throws Exception {

        // info
        System.out.println("Z1 CONSUMER");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
//        channel.basicQos(1);

        // queue
        String QUEUE_NAME = "queue1";
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // consumer (handle msg)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);

                System.out.println("Received: " + message);
                System.out.println("Started message processing...");
                try {
                    int timeToSleep = Integer.parseInt(message);
                    Thread.sleep(timeToSleep * 1000L);
                } catch (InterruptedException e) {
                    System.err.println("Consumer interrupted");
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.err.println("Couldn't parse message as int. Message: " + message);
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("Ended message processing...");

            }
        };

        // start listening
        System.out.println("Waiting for messages...");
//        channel.basicConsume(QUEUE_NAME, true, consumer);
        channel.basicConsume(QUEUE_NAME, false, consumer);

        // close
//        channel.close();
//        connection.close();
    }
}
