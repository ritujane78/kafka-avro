package com.jane.kafka.broker.scheduler;

import com.jane.avro.data.EmployeeBackward;
import com.jane.avro.data.Hello;
import com.jane.kafka.broker.producer.EmployeeBackwardProducer;
import com.jane.kafka.broker.producer.HelloProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class EmployeeBackwardScheduler {

    private final EmployeeBackwardProducer employeeBackwardProducer;

    private Faker faker = new Faker();

    public EmployeeBackwardScheduler(EmployeeBackwardProducer employeeBackwardProducer) {
        this.employeeBackwardProducer = employeeBackwardProducer;
    }

    @Scheduled(fixedRate = 1000)
    public void sendToKafka() {
        EmployeeBackward data = EmployeeBackward.newBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                        .build();

        employeeBackwardProducer.sendToKafka(data);
    }
}
