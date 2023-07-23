package com.example.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private String userName;
    private String password;
    private int userId;

    private ArrayList<Order> orders;
    private int counter = 0;


    public int getUser_id() {
        return userId;
    }

    public void setUser_id(int user_id) {
        this.userId = user_id;
    }

    public User(){};

    public User(String userName, String password, int u) {
        this.userName = userName;
        this.password = password;
        this.userId = u;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setOrders(Order od){
        this.orders.set(counter, od);
        this.counter++;
    }
}
