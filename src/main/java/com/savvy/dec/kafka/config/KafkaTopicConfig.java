package com.savvy.dec.kafka.config;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;


@Configuration
public class KafkaTopicConfig {

    public static final String TOPIC1 = "topic1";
    public static final String TOPIC2 = "topic2";
    public static final String TOPIC3 = "topic3";
    public static final String REGISTER = "register";
    public static final String NOTIFICATION = "notification";

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServer;

    @Bean
    public KafkaAdmin admin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        return new KafkaAdmin(configs);
    }

    @Bean
    public KafkaAdmin.NewTopics createTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(TOPIC1)
                        .partitions(2)
                        .replicas(2)
                        .build(),
//                TopicBuilder.name(TOPIC2)
//                        .partitions(3)
//                        .replicas(2)
//                        .build(),
//                TopicBuilder.name(TOPIC3)
//                        .partitions(3)
//                        .replicas(2)
//                        .build(),
                TopicBuilder.name(REGISTER)
                        .partitions(2)
                        .replicas(2)
                        .build(),
                TopicBuilder.name(NOTIFICATION)
                        .partitions(2)
                        .replicas(2)
                        .build());
    }
}
