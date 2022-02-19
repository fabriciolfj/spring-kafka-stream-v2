package com.github.fabriciolfj.kafkastream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Example {

    @Test
    void test() {
        final String value = "test";
        final var result = Arrays.asList(value.split("\\W+"));
        System.out.println(result);
    }
}
