package com.github.fabriciolfj.kafkastream.componente;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class WordCountProcessor {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    @Autowired
    void buildPipeline(final StreamsBuilder streamsBuilder) {
        //stream a partir de um topic de entrada, usando chave e valor definido no Serdes
        KStream<String, String> messageStream = streamsBuilder
                .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE));

        //crie um ktable para transformar, dividir, agrupar e contar os dados
        KTable<String, Long> wordCounts = messageStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
                .groupBy((key, word) -> word, Grouped.with(STRING_SERDE, STRING_SERDE))
                .count(Materialized.as("counts"));

        //materializar o resultado em um topic de saida
        wordCounts.toStream().to("output-topic");
    }
}
