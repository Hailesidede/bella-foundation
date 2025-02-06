package com.bellafoundation.bella_foundation_user_service.config.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
    @KafkaListener(topics="my-topic", groupId = "my-group-id")
    public void listen(String message){
        System.out.println("Received this message:::"+message);
    }
}
