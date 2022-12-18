package com.savvy.dec.kafka.listener;

import com.google.gson.Gson;
import com.savvy.dec.entity.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class KafkaListeners {

    @KafkaListener(
            topics = {"topic1", "topic2", "topic3", "notification"},
            groupId = "string"
    )
    void listener(String data) {
        System.out.println("data = " + data);
    }

    @KafkaListener(
            topics = {"register"},
            groupId = "Object"
    )
    void receiveData(String data){
        System.out.println("data = " + data);
        Gson gson = new Gson();
        User user = gson.fromJson(data, User.class);
        System.out.println("data = " + data);
        System.out.println("gson = " + user);
    }
}
