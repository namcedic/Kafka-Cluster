package com.savvy.dec.controller;

import com.savvy.dec.entity.KafkaRequest;
import com.savvy.dec.entity.RegistrationRequest;
import com.savvy.dec.kafka.service.KafkaService;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RestController
public class KafkaController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping("/kafka/send")
    public Object send(@RequestBody KafkaRequest kafkaRequest) throws ExecutionException, InterruptedException {
        return kafkaService.sendObject(kafkaRequest.getTopic(), kafkaRequest.getData());
    }

    @PostMapping("/kafka/sendObject")
    public Object sendObject(@RequestBody RegistrationRequest registrationRequest) throws ExecutionException, InterruptedException {
        return kafkaService.sendObject("topic7", registrationRequest);
    }
}
