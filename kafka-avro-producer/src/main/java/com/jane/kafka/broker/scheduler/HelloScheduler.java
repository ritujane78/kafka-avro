package com.jane.kafka.broker.scheduler;

import com.jane.avro.data.Hello;
import com.jane.kafka.broker.producer.HelloProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HelloScheduler {

    private final HelloProducer helloProducer;

    public HelloScheduler(HelloProducer helloProducer) {
        this.helloProducer = helloProducer;
    }

    @Scheduled(fixedRate = 1000)
    public void sendToKafka() {
        Hello data = Hello.newBuilder()
                        .setMyIntField(ThreadLocalRandom.current().nextInt())
                        .setMyStringField("Now is " + LocalDateTime.now())
                        .build();

        helloProducer.sendToKafka(data);
    }
}
