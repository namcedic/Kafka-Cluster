package com.savvy.dec.kafka.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public interface KafkaService {
    Object sendObject(String topic, Object object) throws ExecutionException, InterruptedException;
}
