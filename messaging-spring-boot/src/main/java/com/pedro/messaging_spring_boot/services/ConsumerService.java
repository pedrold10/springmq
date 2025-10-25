package com.pedro.messaging_spring_boot.services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    
    @KafkaListener(topics = "hello-topic", groupId = "group-1")
    public void receiveMessage(String message){
        System.out.println("Consumer message: " + message);
    }
}
