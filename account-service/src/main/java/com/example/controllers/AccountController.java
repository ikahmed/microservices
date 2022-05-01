package com.example.controllers;

import com.example.dtos.Account;
import com.example.services.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @PostMapping("/account")
    public Account createAccount(){
        return new Account();
    }

    @GetMapping("/account/{id}")
    public Account getAccountId(@PathVariable("id") String id){
        return accountService.getAccountById(id);
    }
}
