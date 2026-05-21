    package com.jane.kafka.broker.consumer;

    import com.jane.avro.data.EmployeeBackward;
    import com.jane.avro.data.EmployeeForward;
    import org.apache.kafka.clients.consumer.ConsumerRecord;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.kafka.annotation.KafkaListener;
    import org.springframework.stereotype.Service;

    @Service
    public class EmployeeForwardConsumer {
        private static final Logger logger = LoggerFactory.getLogger(EmployeeForwardConsumer.class);

        @KafkaListener(topics = "sc-employee-forward")
        public void receive(ConsumerRecord<String, EmployeeForward> record) {
            logger.info("Received record: " + record.value());
        }
    }
