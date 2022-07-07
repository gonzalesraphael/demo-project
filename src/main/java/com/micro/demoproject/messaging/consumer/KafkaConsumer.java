package com.micro.demoproject.messaging.consumer;

import com.micro.demoproject.data.request.SomeRequest;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value(value = "$${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "someKafkaListenerContainerFactory")
    public void testeKafkaConsumer(ConsumerRecord<String, SomeRequest> record) {
        logger.info("Message received: " + record.value());
    }
}
