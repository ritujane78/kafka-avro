# Kafka + Avro + Schema Registry Demo

A multi-module Apache Kafka project demonstrating how to build Kafka Producers and Consumers using **Apache Avro** and **Schema Registry** with Java and Gradle.

This repository contains separate producer and consumer applications configured for schema-based event streaming and schema evolution experiments.

---

# Architecture Overview

```text
+-------------------+         +-------------------+
| Kafka Producer    | ----->  | Apache Kafka      |
| (Avro Serializer) |         | Topic             |
+-------------------+         +-------------------+
                                          |
                                          v
                           +----------------------------+
                           | Kafka Consumer             |
                           | (Avro Deserializer)        |
                           +----------------------------+

                 +--------------------------------+
                 | Confluent Schema Registry      |
                 | Stores & validates AVRO schema |
                 +--------------------------------+
```

---

# Repository Structure

```text
kafka-avro/
│
├── kafka-avro-consumer/
│   ├── gradle/
│   ├── screenshots/
│   ├── src/
│   ├── build.gradle
│   ├── settings.gradle
│   ├── gradlew
│   └── gradlew.bat
│
├── kafka-avro-producer/
│   ├── gradle/
│   ├── screenshots/
│   ├── src/
│   ├── build.gradle
│   ├── settings.gradle
│   ├── gradlew
│   └── gradlew.bat
│
├── screenshots/
└── README.md
```

---

# Modules

## kafka-avro-producer

The producer module is responsible for:

- Publishing Kafka events
- Serializing messages using Avro
- Registering schemas in Schema Registry
- Producing schema-compatible records
- Demonstrating producer-side schema evolution


## kafka-avro-consumer

The consumer module is responsible for:

- Consuming Kafka events
- Deserializing Avro payloads
- Reading schemas from Schema Registry
- Validating compatibility
- Logging and processing incoming events

---

# Tech Stack

| Technology | Purpose |
|---|---|
| Java | Application development |
| Apache Kafka | Event streaming platform |
| Apache Avro | Binary serialization format |
| Schema Registry | Schema management |
| Gradle | Build automation |
| Docker | Local Kafka environment |
| Spring Boot *(expected)* | Application framework |

---

Docker Compose is recommended for local development.

---

Example schema structure:

```json
{
  "type": "record",
  "namespace": "com.jane.avro.data",
  "name": "EmployeeForward",
  "fields": [
    {
      "name": "firstName",
      "type": "string"
    },
    {
      "name": "lastName",
      "type": "string"
    }
  ]
}
```

---
# Screenshots

The repository includes screenshot directories for:

- Kafka setup
- Schema Registry responses
- Producer output
- Consumer logs
- Topic validation

---

# Learning Goals Covered

This repository is useful for learning:

- Apache Kafka fundamentals
- Avro serialization
- Schema Registry integration
- Schema evolution
- Kafka producer/consumer architecture
- Event-driven systems
- Binary serialization formats



