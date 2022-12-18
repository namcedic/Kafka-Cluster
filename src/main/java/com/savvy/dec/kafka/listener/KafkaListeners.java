package com.savvy.dec.kafka.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {
    Logger LOG = LoggerFactory.getLogger(KafkaListeners.class);
    @KafkaListener(
            topics = {"topic1", "topic2", "topic3", "notification"},
            groupId = "string"
    )
    void listener(String data) {
        LOG.info(data);
    }

    @KafkaListener(
            topics = {"register"},
            groupId = "Object"
    )
    void receiveData(String data){
        LOG.info(data);
    }
}
