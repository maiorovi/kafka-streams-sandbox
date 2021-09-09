package com.ymaiorov.yellapp;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;

public class YellingAppMain {


    private static final Logger LOG = LogManager.getLogger(YellingAppMain.class);

    public static void main(String[] args) throws InterruptedException {

        LOG.info("Hello World!");

        var stream = new YellingAppStream();
        var configProvider = new KStreamConfigurationProvider();

        var kafkaStreams  = stream.createStream(configProvider.get());

        kafkaStreams.start();
        Thread.sleep(3500000);
        LOG.info("Shutting down the Yelling APP now");
        kafkaStreams.close();
    }
}
