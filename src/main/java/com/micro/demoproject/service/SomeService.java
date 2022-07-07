package com.micro.demoproject.service;

import com.micro.demoproject.data.request.SomeRequest;
import com.micro.demoproject.messaging.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SomeService {

    private final KafkaProducer kafkaProducer;

    public void someOperation(SomeRequest request) {
        kafkaProducer.testKafkaProducer(request);
    }
}
