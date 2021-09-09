package com.ymaiorov.yellapp;

import org.apache.kafka.streams.StreamsConfig;

import java.util.Properties;

public class KStreamConfigurationProvider {

    public Properties get() {
        var props = new Properties();

        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "yellingAppId");

        return props;
    }
}
