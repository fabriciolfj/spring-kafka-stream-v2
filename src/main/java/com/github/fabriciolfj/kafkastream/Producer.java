package com.github.fabriciolfj.kafkastream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(final String message) {
        kafkaTemplate.send("input-topic", message)
                .addCallback(
                        result -> System.out.println("Sucesso"),
                        ex  -> System.out.println(ex.getMessage())
                );
    }
}
