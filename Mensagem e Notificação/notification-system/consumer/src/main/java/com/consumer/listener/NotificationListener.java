package com.consumer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener{

    @KafkaListener(topics = "notificacao-topic", groupId = "notificacao-consumer")
    public void consume(String mensagem) {
        System.out.println("======================================================================\n"
        + "📩 Nova notificação recebida: " + mensagem +
        "\n======================================================================");
    }
}