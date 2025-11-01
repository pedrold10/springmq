package com.pedro.messaging_spring_boot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pedro.messaging_spring_boot.services.ProducerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class KafkaController {
    private ProducerService producerService;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name){
        producerService.sendMessage("Hello "+name);
        return "OK!";
    }
}
