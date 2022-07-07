package com.micro.demoproject.messaging.producer;

import com.micro.demoproject.data.request.SomeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final String topic;
    private final KafkaTemplate<String, SomeRequest> kafkaTemplate;

    public KafkaProducer(@Value("${topic.name}") String topic, KafkaTemplate<String, SomeRequest> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void testKafkaProducer(SomeRequest request) {
        kafkaTemplate.send(topic, request).addCallback(
                success -> logger.info("sucess: " + success.getProducerRecord().value()),
                failure -> logger.info("failure: " + failure.getMessage())
        );
    }
}
