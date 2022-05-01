package com.example.dtos;

import java.math.BigDecimal;

public class Order {

    private String id;
    private String item;
    private BigDecimal cost;

    public Order() {
    }

    public Order(String id, String item, BigDecimal cost) {
        this.id = id;
        this.item = item;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", item='" + item + '\'' +
                ", cost=" + cost +
                '}';
    }
}
