package com.example.services;

import com.example.dtos.Account;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class AccountService {

    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);


    public Account getAccountById(String id){
        logger.debug(" id ",id);

        return new Account(UUID.randomUUID().toString(),"ABC title",true, new BigDecimal(1000));
    }
}
