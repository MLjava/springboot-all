package fish.study.manager;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * @author malin
 */
@Component
public class RabbitMQManager {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendMessage(String msg) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setConsumerQueue("rabbit");
        messageProperties.setContentEncoding(StandardCharsets.UTF_8.name());
        Message message = new Message(msg.getBytes(StandardCharsets.UTF_8), messageProperties);
        rabbitTemplate.send(message);
    }


}
