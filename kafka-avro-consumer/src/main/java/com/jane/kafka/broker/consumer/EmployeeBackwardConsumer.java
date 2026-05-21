    package com.jane.kafka.broker.consumer;

    import com.jane.avro.data.Avro01;
    import com.jane.avro.data.EmployeeBackward;
    import org.apache.kafka.clients.consumer.ConsumerRecord;
    import org.slf4j.Logger;
    import org.slf4j.LoggerFactory;
    import org.springframework.kafka.annotation.KafkaListener;
    import org.springframework.stereotype.Service;

    @Service
    public class EmployeeBackwardConsumer {
        private static final Logger logger = LoggerFactory.getLogger(EmployeeBackwardConsumer.class);

        @KafkaListener(topics = "sc-employee-backward")
        public void receive(ConsumerRecord<String, EmployeeBackward> record) {
            logger.info("Received record: " + record.value());
        }
    }
