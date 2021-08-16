package fish.study.controller;

import fish.study.manager.RabbitMQManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author malin
 */
@RestController
public class ProducerController {

    @Autowired
    private RabbitMQManager rabbitMQManager;

    @GetMapping("/send/message")
    public void sendMessage(String msg) {
        rabbitMQManager.sendMessage(msg);
    }

}
