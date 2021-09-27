package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MainController {
    private final KafkaService kafkaService;

    @GetMapping("/send-message")
    void sendMessage(@Valid MessageDTO messageDTO) {
        kafkaService.sendMessage(messageDTO);
    }
}
