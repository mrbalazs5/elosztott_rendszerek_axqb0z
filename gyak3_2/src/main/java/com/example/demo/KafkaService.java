package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaService implements KafkaServiceInterface {
    private final KafkaTemplate kafkaTemplate;
    private final ObjectMapper objectMapper;

    private final String chatRoom = "chat-room";

    public void sendMessage(MessageDTO messageDTO) {
        try {
            String message = objectMapper.writeValueAsString(messageDTO);

            kafkaTemplate.send(chatRoom, message);
        } catch (JsonProcessingException e) {}
    }
}
