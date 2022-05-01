package com.example.service;

import com.example.dtos.Order;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


@Component
public class Producer {

    @Value("${topic.name}")
    private String topic;

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public Producer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public boolean sendMessage(Order order){
        try {
            String orderAsMessage = objectMapper.writeValueAsString(order);
            kafkaTemplate.send(topic, orderAsMessage);
        }catch (JsonProcessingException jsonProcessingException){
            //failed to send message
            return false;
        }catch(Exception e){
            //cause is different than processing may be IO or any thing else
            return false;
        }
        return true;
    }
}
