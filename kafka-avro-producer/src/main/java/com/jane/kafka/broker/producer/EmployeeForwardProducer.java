package com.jane.kafka.broker.producer;

import com.jane.avro.data.EmployeeForward;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeForwardProducer {

    private final KafkaTemplate<String, EmployeeForward> kafkaTemplate;

    public EmployeeForwardProducer(KafkaTemplate<String, EmployeeForward> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(EmployeeForward message) {
        kafkaTemplate.send("sc-employee-forward", message);
    }
}
