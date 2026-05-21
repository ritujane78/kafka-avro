package com.jane.kafka.broker.producer;

import com.jane.avro.data.EmployeeBackward;
import com.jane.avro.data.Hello;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeBackwardProducer {

    private final KafkaTemplate<String, EmployeeBackward> kafkaTemplate;

    public EmployeeBackwardProducer(KafkaTemplate<String, EmployeeBackward> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendToKafka(EmployeeBackward message) {
        kafkaTemplate.send("sc-employee-backward", message);
    }
}
