package com.producer.controller;

import com.producer.dto.NotificationRequestDTO;
import com.producer.service.KafkaProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificacao")
public class NotificationController {

    private final KafkaProducerService producerService;

    public NotificationController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public NotificationRequestDTO sendNotification(@RequestBody NotificationRequestDTO mensagem) {
        producerService.sendMessage(mensagem);
        return mensagem;
    }
}