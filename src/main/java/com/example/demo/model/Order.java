package com.example.demo.model;

import lombok.Data;

@Data
public class Order {
    private int id;
    private double fee;
    private String enterDate;
    private int courseId;
    private String paymentDate;
    private boolean approved;
    private String note;
}
