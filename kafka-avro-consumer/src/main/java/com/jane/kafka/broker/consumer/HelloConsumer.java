package com.jane.kafka.broker.consumer;

import com.jane.avro.data.Hello;
import com.jane.kafka.broker.message.HelloPositiveMessage;
import io.confluent.kafka.streams.serdes.avro.SpecificAvroSerde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.Printed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Map;

//@Component
public class HelloConsumer {
//    @Autowired
    void kstreamHello(StreamsBuilder builder,
                      @Autowired @Qualifier("configSerde")Map<String, String> configSerde) {
        var helloSerde = new SpecificAvroSerde<Hello>();

        helloSerde.configure(configSerde, false);

        builder.stream("sc-hello", Consumed.with(Serdes.String(), helloSerde))
                .mapValues(this::mapHello).print(Printed.toSysOut());

    }

    private HelloPositiveMessage mapHello(Hello original) {
        var result = new HelloPositiveMessage();

        result.setPositiveInt(Math.abs(original.getMyIntField()));
        result.setUpperCaseString(original.getMyStringField().toUpperCase());

        return result;
    }

}
