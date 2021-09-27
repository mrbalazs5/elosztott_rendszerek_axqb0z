package com.example.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaService implements KafkaServiceInterface {
    @KafkaListener(id = "gyak3", topics = "chat-room")
    public void listen(String message) {
        System.out.println(message);
    }
}
