package com.jane.kafka.broker.consumer;

import com.jane.avro.data.Avro01;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;

//@Service
public class Avro01Consumer {
    private static final Logger logger = LoggerFactory.getLogger(Avro01Consumer.class);

    @KafkaListener(topics = "sc-avro01")
    public void receive(Avro01 message) {
        logger.info("Received: " + message);
    }
}
