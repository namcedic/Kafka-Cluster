package com.savvy.dec.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaServiceImpl implements KafkaService{
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Override
    public Object sendObject(String topic, Object object) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = kafkaTemplate.send(topic, object);
       return completableFuture.get().toString();
    }

}
