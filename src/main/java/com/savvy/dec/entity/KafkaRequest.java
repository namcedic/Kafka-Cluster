package com.savvy.dec.entity;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class KafkaRequest {
    private String topic;
    private String data;
}
