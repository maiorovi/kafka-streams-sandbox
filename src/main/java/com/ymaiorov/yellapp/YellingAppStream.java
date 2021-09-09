package com.ymaiorov.yellapp;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;

import java.util.Properties;

public class YellingAppStream {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    public KafkaStreams createStream(Properties properties) {
        StreamsBuilder streamBuilder = new StreamsBuilder();

        streamBuilder
                .stream("src-topic", Consumed.with(STRING_SERDE, STRING_SERDE))
                .mapValues(s -> s.toUpperCase())
                .to("to-topic", Produced.with(STRING_SERDE, STRING_SERDE));

        return new KafkaStreams(streamBuilder.build(), properties);
    }
}
