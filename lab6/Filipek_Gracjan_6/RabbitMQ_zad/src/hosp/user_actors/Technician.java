package hosp.user_actors;

import com.rabbitmq.client.*;
import hosp.*;
import hosp.messages.ExaminationRequest;
import hosp.messages.ExaminationResult;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Technician implements UserActor {
    final static public String QUEUE_PREFIX = "technician";

    private final int id;
    private final InjuryType[] knownInjuryTypes = new InjuryType[2];
    private final String queueName;

    public Technician(int id) {
        this.id = id;
        this.queueName = QUEUE_PREFIX + id;
    }

    @Override
    public void serveTheUser(BufferedReader in) {
        System.out.println("Welcome technician" + id + "!");

        // read injuries known by this technician
        UtilsDialog.readKnownInjuryTypes(knownInjuryTypes, in);

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.basicQos(1);

            // for logs
            channel.queueDeclare(QUEUE_PREFIX + id, true, false, false, null);
            channel.queueBind(queueName, CommonRabbitMqNames.INFOS_EXCHANGE_NAME, "");

            // start a thread; it will read all messages intended for this doctor
            new UserActorReader(connection, queueName).run();

            String line;
            System.out.println("Commands: " + Arrays.toString(knownInjuryTypes) + ", exit|x");
            do {
                line = in.readLine();
                if (line.equals("help") || line.equals("h")) {
                    System.out.println("Commands: " + Arrays.toString(knownInjuryTypes) + ", exit|x");
                }
                else if (line.equals(knownInjuryTypes[0].getText())) {
                    handleExaminationRequest(in, channel, knownInjuryTypes[0]);
                }
                else if (line.equals(knownInjuryTypes[1].getText())) {
                    handleExaminationRequest(in, channel, knownInjuryTypes[1]);
                }
                else if (line.isEmpty()) {
                    continue;
                }
                else if (line.equals("exit") || line.equals("x")) {
                    line = null;
                }
                else {
                    System.out.println("Unknown command");
                }
            } 
            while (line != null);
            
        } catch (IOException | TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    private void handleExaminationRequest(BufferedReader in, Channel channel, InjuryType injuryType) throws IOException {
        var request =
                channel.basicGet(
                        CommonRabbitMqNames.getExaminationRequestsQueueName(injuryType),
                        false);

        if (request == null) {
            System.out.println("Examination request of type '" + injuryType.getText() + "' not found");
            return;
        }

        ExaminationRequest examinationRequest;
        if (request.getProps().getHeaders().get("messageClass").toString().equals(ExaminationRequest.class.getSimpleName())) {
            examinationRequest = (ExaminationRequest) UtilsSerialization.deserialize(request.getBody());
        } else {
            System.out.println("Message class unknown or unsupported");
            return;
        }


        System.out.println("Received an examination request: " + examinationRequest.toString());

        System.out.println("(press enter to process the request...)");
        in.readLine();

        ExaminationResult examinationResult = new ExaminationResult(
                examinationRequest.patient(),
                examinationRequest.injuryType(),
                "done");

        AMQP.BasicProperties props = new AMQP.BasicProperties.Builder()
                .headers(Map.of("messageClass", examinationResult.getClass().getSimpleName()))
                .build();

        channel.basicPublish(
                CommonRabbitMqNames.EXAMINATION_RESULTS_EXCHANGE_NAME,
                request.getProps().getHeaders().get("returnKey").toString(),
                props,
                UtilsSerialization.serialize(examinationResult));

        System.out.println("Request processed");
        channel.basicAck(request.getEnvelope().getDeliveryTag(), false);
    }

}
