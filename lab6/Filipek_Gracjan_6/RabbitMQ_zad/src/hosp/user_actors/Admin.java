package hosp.user_actors;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import hosp.CommonRabbitMqNames;
import hosp.UtilsSerialization;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Admin implements UserActor {
    final static public String QUEUE_PREFIX = "admin";

    private final int id;
    private final String queueName;

    public Admin(int id) {
        this.id = id;
        this.queueName = QUEUE_PREFIX + id;
    }

    @Override
    public void serveTheUser(BufferedReader in) {
        System.out.println("Welcome admin" + id + "!");

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.basicQos(1);


            // queue should be durable
            var adminQueue = channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, CommonRabbitMqNames.LOGS_EXCHANGE_NAME, queueName);

            // start a thread; it will read all messages intended for this admin
            new UserActorReader(connection, queueName).run();

            String line;
            System.out.println("Commands: send|s, exit|x");
            do {
                line = in.readLine();
                switch (line) {
                    case "help", "h":
                        System.out.println("Commands: send|s, exit|x");
                        break;

                    case "send", "s":
                        System.out.print("Message to send: ");
                        sendInfo(channel, in.readLine());
                        break;

                    case "exit", "x":
                        line = null;
                        break;

                    case "":
                        break;

                    default:
                        System.out.println("Unknown command");
                }
            }
            while (line != null);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendInfo(Channel channel, String string) throws IOException {
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .headers(Map.of(
                        "messageClass", String.class.getSimpleName()))
                .build();

        channel.basicPublish(
                CommonRabbitMqNames.INFOS_EXCHANGE_NAME,
                "",
                props,
                string.getBytes(StandardCharsets.UTF_8)
        );
    }
}
