package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private double fee;
    private String enterDate;
    private int courseId;
    private String paymentDate;
    private boolean approved;
    private String note;
    private int studentId;
}
