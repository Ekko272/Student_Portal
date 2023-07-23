package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.User;

public interface AdminService {
    int addCourses(Course c);
    int deleteCourse(Integer id);
    Course serachCourse(Integer id);

    User searchUser(String username);
}
