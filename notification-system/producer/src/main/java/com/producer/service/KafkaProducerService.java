package com.producer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.producer.dto.NotificationRequestDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "notificacao-topic";
    private final ObjectMapper objectMapper;


    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void sendMessage(NotificationRequestDTO notification) {
        try {
            String message = notification.getConteudo();
            kafkaTemplate.send(TOPIC, message);
            System.out.println("✅ Mensagem enviada: " + message);
        } catch (Exception e) {
            System.err.println("❌ Erro ao serializar mensagem: " + e.getMessage());
        }
    }
}