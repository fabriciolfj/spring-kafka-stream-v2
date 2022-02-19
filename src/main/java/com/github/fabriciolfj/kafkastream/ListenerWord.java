package com.github.fabriciolfj.kafkastream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerWord {

    @KafkaListener(topics = {"output-topic"}, groupId = "1")
    public void event(final byte[] value) {
        String test = new String(value);
        System.out.println(test);
    }
}
