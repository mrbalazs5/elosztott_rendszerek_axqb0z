package com.example.demo;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfiguration {
    private final String chatRoom = "chat-room";

    @Bean
    public NewTopic topicExample() {
        return TopicBuilder.name(chatRoom)
                .partitions(6)
                .replicas(3)
                .build();
    }
}
