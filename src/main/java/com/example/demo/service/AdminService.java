package com.example.demo.service;

import com.example.demo.model.Course;

public interface AdminService {
    int addCourses(Course c);
    int deleteCourse(Integer id);
    Course serachCourse(Integer id);
}
