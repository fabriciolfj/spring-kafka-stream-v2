package com.github.fabriciolfj.kafkastream;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StoreQueryParameters;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.config.StreamsBuilderFactoryBean;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/count")
public class Controller {

    @Autowired
    private StreamsBuilderFactoryBean streamsBuilderFactoryBean;

    @Autowired
    private Producer kafkaProducer;

    @GetMapping("/{word}")
    public Long getWordCount(@PathVariable("word") final String word) {
        final KafkaStreams streams = streamsBuilderFactoryBean.getKafkaStreams();
        ReadOnlyKeyValueStore<String, Long> counts = streams
                .store(StoreQueryParameters.fromNameAndType("counts", QueryableStoreTypes.keyValueStore()));

        return counts.get(word);
    }

    @PostMapping("/message/{word}")
    public void setMessage(@PathVariable("word") final String message) {
        kafkaProducer.sendMessage(message);
    }
}
