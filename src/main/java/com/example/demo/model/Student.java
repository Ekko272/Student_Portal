package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User{
    private List<Course> courseList;

    public Student(){}
    public Student(List<Course> courseList) {
        this.courseList = new ArrayList<>();
    }

    public Student(int id, String userName, String password) {
        super(id, userName, password);
    }

    public Student(String userName, String password) {
        super(userName, password);
    }

    //once student has at least one course, allocate memory for ArrayList(saving memory compare to directly initialize courseList in property filed)
    public void addCourse(Course course) {
        if (courseList == null) {
            courseList = new ArrayList<>();
        }
        courseList.add(course);
    }

    @Override
    public String toString() {
        String coursesInfo = null;
        for (Course course : courseList) {
            coursesInfo += course.toString();
        }
        return coursesInfo;
    }
}
