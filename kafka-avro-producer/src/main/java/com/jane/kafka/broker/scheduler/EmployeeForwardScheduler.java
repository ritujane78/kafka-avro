package com.jane.kafka.broker.scheduler;

import com.jane.avro.data.EmployeeForward;
import com.jane.kafka.broker.producer.EmployeeForwardProducer;
import net.datafaker.Faker;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class EmployeeForwardScheduler {

    private final EmployeeForwardProducer employeeForwardProducer;

    private Faker faker = new Faker();

    public EmployeeForwardScheduler(EmployeeForwardProducer employeeForwardProducer) {
        this.employeeForwardProducer = employeeForwardProducer;
    }

    @Scheduled(fixedRate = 1000)
    public void sendToKafka() {
        var data = EmployeeForward.newBuilder()
                .setFirstName(faker.name().firstName())
                .setLastName(faker.name().lastName())
                .setEmail(faker.internet().emailAddress())
                        .build();

        employeeForwardProducer.sendToKafka(data);
    }
}
