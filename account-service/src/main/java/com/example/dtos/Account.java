package com.example.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

public class Account implements Serializable {

    private String id;
    private String title;
    private boolean active;
    private BigDecimal balance;

    public Account() {
    }

    public Account(String id, String title, boolean active, BigDecimal balance) {
        this.id = id;
        this.title = title;
        this.active = active;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
