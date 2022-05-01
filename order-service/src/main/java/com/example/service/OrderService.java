package com.example.service;

import com.example.dtos.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private final Producer producer;

    private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    public OrderService(Producer producer) {
        this.producer = producer;
    }

    public boolean placeOrder(Order order){
        logger.debug(" order ",order);
        return producer.sendMessage(order);
    }
}
