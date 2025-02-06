package com.bellafoundation.bella_foundation_user_service.controller;

import com.bellafoundation.bella_foundation_user_service.config.kafka.MessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

    @Autowired
    public MessageProducer messageProducer;

    @PostMapping("/send")
    public void sendMessage(@RequestParam("message") String message){
        messageProducer.sendMessage("my-topic",message);
    }
}
