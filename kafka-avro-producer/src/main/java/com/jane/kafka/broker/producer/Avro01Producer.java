package com.jane.kafka.broker.producer;

import com.jane.avro.data.Avro01;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Avro01Producer {
    @Autowired
    private KafkaTemplate<String, Avro01> kafkaTemplate;

    public void send(Avro01 avro01) {
        kafkaTemplate.send("sc-avro01", avro01);
    }
}
