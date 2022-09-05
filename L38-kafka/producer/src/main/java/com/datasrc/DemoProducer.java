package com.datasrc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoProducer {
    private static final Logger log = LoggerFactory.getLogger(DemoProducer.class);

    public static void main(String[] args) {
        var producer = new MyProducer("localhost:9092");

        var dataSender = new DataSender(producer, stringValue -> log.info("asked, value:{}", stringValue));
        var valueSource = new StringValueSource(dataSender::dataHandler);
        valueSource.generate();
    }
}
