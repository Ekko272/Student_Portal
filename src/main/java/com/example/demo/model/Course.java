package com.example.demo.model;

import java.io.Serializable;

public class Course implements Serializable {
    protected int id;
    private String name;
    private String startDate;
    public String endDate;
    public String timeInterval;
    public int maxStudent;
    public int enrollment;
    private String location;
    private int showEnable;
    private String description;
    private double price;
    public String mode;
    private String weekDays;
    private String instructor;
    private int numOfWeeks;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", maxStudent=" + maxStudent +
                ", enrollment=" + enrollment +
                ", location='" + location + '\'' +
                ", startDate='" + startDate + '\'' +
                ", showEnable=" + showEnable +
                ", description='" + description + '\'' +
                ", endDate='" + endDate + '\'' +
                ", timeInterval='" + timeInterval + '\'' +
                ", price=" + price +
                ", mode='" + mode + '\'' +
                ", weekDays='" + weekDays + '\'' +
                ", instructor='" + instructor + '\'' +
                ", numOfWeeks=" + numOfWeeks +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getShowEnable() {
        return showEnable;
    }

    public void setShowEnable(int showEnable) {
        this.showEnable = showEnable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(String timeInterval) {
        this.timeInterval = timeInterval;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(String weekDays) {
        this.weekDays = weekDays;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getNumOfWeeks() {
        return numOfWeeks;
    }

    public void setNumOfWeeks(int numOfWeeks) {
        this.numOfWeeks = numOfWeeks;
    }

    public Course() {
    }

    public Course(int id) {
        this.id = id;
    }

    public Course(int id, String name, int maxStudent, int enrollment, String location, String startDate, int showEnable, String description, String endDate, String timeInterval, double price, String mode, String weekDays, String instructor, int numOfWeeks) {
        this.id = id;
        this.name = name;
        this.maxStudent = maxStudent;
        this.enrollment = enrollment;
        this.location = location;
        this.startDate = startDate;
        this.showEnable = showEnable;
        this.description = description;
        this.endDate = endDate;
        this.timeInterval = timeInterval;
        this.price = price;
        this.mode = mode;
        this.weekDays = weekDays;
        this.instructor = instructor;
        this.numOfWeeks = numOfWeeks;
    }
}
