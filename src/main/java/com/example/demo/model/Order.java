package com.example.demo.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Order {
    private int userId;
    private int price;
    private LocalDateTime date;

    public Order(){};

    public Order(int userId, int price, LocalDateTime date) {
        this.userId = userId;
        this.price = price;
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
