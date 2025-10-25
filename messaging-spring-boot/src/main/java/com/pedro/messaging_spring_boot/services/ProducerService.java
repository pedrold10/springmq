package com.pedro.messaging_spring_boot.services;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;

@Service
@AllArgsConstructor
public class ProducerService {
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send("hello-topic", message);
    }
}
