package com.jane.kafka.broker.producer;

import com.jane.avro.data.Hello;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

//@Service
public class HelloProducer {

    private final KafkaTemplate<String, Hello> kafkaTemplate;

    public HelloProducer(KafkaTemplate<String, Hello> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(Hello message) {
        kafkaTemplate.send("sc-hello", message);
    }
}
