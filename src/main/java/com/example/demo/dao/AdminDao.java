package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.User;

public interface AdminDao {
    int addCourse(Course c);
    Course serachCourse(Integer id);
    int deleteCourse(Integer id);

    User searchUser(String username);

    int addUser(User user);

}
