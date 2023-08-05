package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Order {
    private int id;
    private double fee;
    private Date enterDate;
    private int courseId;
    private Date paymentDate;
    private boolean approved;
    private String note;
    private int studentId;
    public Order(){};
}
