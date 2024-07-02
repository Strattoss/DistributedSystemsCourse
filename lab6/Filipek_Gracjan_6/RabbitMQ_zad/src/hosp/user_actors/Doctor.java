package hosp.user_actors;

import com.rabbitmq.client.*;
import hosp.*;
import hosp.messages.ExaminationRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Doctor implements UserActor {
    final static public String QUEUE_PREFIX = "doctor";

    private final int intId;
    private final String id;
    private final String queueName;

    public Doctor(int intId) {
        this.intId = intId;
        this.id = QUEUE_PREFIX + intId;
        this.queueName = QUEUE_PREFIX + intId;
    }

    @Override
    public void serveTheUser(BufferedReader in) {
        System.out.println("Welcome doctor" + intId + "!");

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.basicQos(1);

            var doctorQueue = channel.queueDeclare(queueName, true, false, false, null);
            channel.queueBind(queueName, CommonRabbitMqNames.EXAMINATION_RESULTS_EXCHANGE_NAME, queueName);
            channel.queueBind(queueName, CommonRabbitMqNames.INFOS_EXCHANGE_NAME, "");

            // start a thread; it will read all messages intended for this doctor
            new UserActorReader(connection, queueName).run();

            String line;
            System.out.println("Commands: send-random|sr, send-custom|sc, help|h, exit|x");
            do {
                line = in.readLine();

                switch (line) {
                    case "help", "h":
                        System.out.println("Commands: send-random|sr, send-custom|sc, help|h, exit|x");
                        break;
                    case "sr", "send-random":
                        ExaminationRequest randomRequest = ExaminationRequest.getRandom(id);
                        sendExaminationRequest(randomRequest, channel);
                        System.out.println("Message sent: " + randomRequest + "\n");
                        break;

                    case "send-custom", "sc":
                        ExaminationRequest request = UtilsDialog.readRequestFromUser(in, id);
                        sendExaminationRequest(request, channel);
                        System.out.println("Message sent: " + request + "\n");
                        break;

                    case "exit", "x":
                        line = null;
                        break;

                    case "":
                        break;

                    default:
                        System.out.println("Unknown command");
                }
            } while (line != null);

        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    private void sendExaminationRequest(ExaminationRequest examinationRequest, Channel channel) throws IOException {
        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .headers(Map.of(
                        "messageClass", examinationRequest.getClass().getSimpleName(),
                        "returnKey", queueName))
                .build();

        channel.basicPublish(
                CommonRabbitMqNames.EXAMINATION_REQUESTS_EXCHANGE_NAME,
                examinationRequest.injuryType().getText(),
                props,
                UtilsSerialization.serialize(examinationRequest)
        );
    }

}
