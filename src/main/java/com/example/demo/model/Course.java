package com.example.demo.model;

import java.io.Serializable;
import java.sql.Time;
import java.time.DayOfWeek;

public class Course implements Serializable {
    protected int c_id;
    public int maxStudent;
    public int enrollment;
    private String location;
    private String sTime;
    private int showEnable;
    private String description;
    public String eTime;
    public String time;
    private String name;
    private double price;
    public String mode;

    @Override
    public String toString() {
        return "Course{" +
                "c_id=" + c_id +
                ", maxStudent=" + maxStudent +
                ", enrollment=" + enrollment +
                ", location='" + location + '\'' +
                ", sTime='" + sTime + '\'' +
                ", showEnable=" + showEnable +
                ", description='" + description + '\'' +
                ", eTime='" + eTime + '\'' +
                ", time='" + time + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", mode='" + mode + '\'' +
                ", c_time='" + c_time + '\'' +
                ", c_day='" + c_day + '\'' +
                ", instructor='" + instructor + '\'' +
                ", nc=" + nc +
                '}';
    }

    private String c_time;
    private String c_day;
    private String instructor;
    private int nc;

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShowEnable() {
        return showEnable;
    }

    public void setShowEnable(int showEnable) {
        this.showEnable = showEnable;
    }

    public int getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }

    public String geteTime() {
        return eTime;
    }

    public void seteTime(String eTime) {
        this.eTime = eTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Course() {
    }

    public Course(int c_id) {
        this.c_id = c_id;
    }

    public Course(int c_id, String teacher, String location, String time,String name,double price) {
        this.c_id = c_id;
        this.instructor = teacher;
        this.location = location;
        this.sTime = time;
        this.name = name;
        this.price = price;

    }
    public Course(int c_id, String teacher, String location, String time,String name,double price,int showStatus) {
        this.c_id = c_id;
        this.instructor = teacher;
        this.location = location;
        this.sTime = time;
        this.name = name;
        this.price = price;
        this.showEnable = showStatus;

    }



    public Course(int id, int nc, double price, String time, String day, String teacher,String location,String name)
    {
        c_id = id;
        this.nc = nc;
        this.price = price;
        this.c_time = time;
        this.c_day = day;
        this.instructor = teacher;
        this.name = name;
        this.location = location;
    }

    public Course(int c_id, int maxStudent, int enrollment, String location, String sTime, int showEnable,
                  String description, String eTime, String time, String name, double price, String mode, String c_time,
                  String c_day, String instructor, int nc) {
        this.c_id = c_id;
        this.maxStudent = maxStudent;
        this.enrollment = enrollment;
        this.location = location;
        this.sTime = sTime;
        this.showEnable = showEnable;
        this.description = description;
        this.eTime = eTime;
        this.time = time;
        this.name = name;
        this.price = price;
        this.mode = mode;
        this.c_time = c_time;
        this.c_day = c_day;
        this.instructor = instructor;
        this.nc = nc;
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getC_day() {
        return c_day;
    }

    public void setC_day(String c_day) {
        this.c_day = c_day;
    }

    public String getC_time() {
        return c_time;
    }

    public void setC_time(String c_time) {
        this.c_time = c_time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getC_id() {
        return c_id;
    }

    public void setC_id(int c_id) {
        this.c_id = c_id;
    }


}
