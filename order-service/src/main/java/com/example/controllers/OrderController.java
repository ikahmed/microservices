package com.example.controllers;

import com.example.dtos.Order;
import com.example.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public void createOrder(@RequestBody Order order){
        orderService.placeOrder(order);
    }

    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable("id") String orderId){
        // get the dummy order
        Order order=new Order(UUID.randomUUID().toString(),"bulb",new BigDecimal(5));
        logger.info("fetching order  {}", orderId);
        return order;
    }
}
