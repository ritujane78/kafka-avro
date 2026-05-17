package com.jane.kafka;

import com.jane.avro.data.Avro01;
import com.jane.kafka.broker.producer.Avro01Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@EnableScheduling
public class KafkaAvroProducerApplication implements CommandLineRunner {

//
//	@Autowired
//	Avro01Producer avro01Producer;

	public static void main(String[] args) {
		SpringApplication.run(KafkaAvroProducerApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		Avro01 data = Avro01.newBuilder()
//				.setFullName("Fullname" + ThreadLocalRandom.current().nextInt())
//				.setMaritalStatus("SINGLE")
//				.setActive(true)
//				.build();
//
//		avro01Producer.send(data);

	}
}
