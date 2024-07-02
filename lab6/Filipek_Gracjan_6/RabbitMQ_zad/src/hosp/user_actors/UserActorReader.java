package hosp.user_actors;

import com.rabbitmq.client.*;
import hosp.messages.ExaminationRequest;
import hosp.messages.ExaminationResult;
import hosp.UtilsSerialization;

import java.io.IOException;

public class UserActorReader implements Runnable{
    private final Channel channel;
    private final String queueName;
    private final Consumer consumer;

    public UserActorReader(Connection connection, String queueName) throws IOException {
        this.channel = connection.createChannel();
        channel.basicQos(1);
        this.queueName = queueName;

        consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag,
                                       Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body
            ) throws IOException {

                if (properties.getHeaders().get("messageClass").toString().equals(String.class.getSimpleName())) {
                    String result = new String(body);
                    System.out.println("[New message] " + result);
                }

                else if (properties.getHeaders().get("messageClass").toString().equals(ExaminationResult.class.getSimpleName())) {
                    ExaminationResult examinationResult = (ExaminationResult) UtilsSerialization.deserialize(body);
                    System.out.println("[New examination result] " + examinationResult);
                }

                else if (properties.getHeaders().get("messageClass").toString().equals(ExaminationRequest.class.getSimpleName())) {
                    ExaminationRequest examinationRequest = (ExaminationRequest) UtilsSerialization.deserialize(body);
                    System.out.println("[New examination request] " + examinationRequest);
                }
                else {
                    System.out.println("[New ??] Received unknown message class: "
                            + properties.getHeaders().get("messageClass").toString());
                }

                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
    }

    @Override
    public void run() {
        try {
            channel.basicConsume(queueName, false, consumer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
