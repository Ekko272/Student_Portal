package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.User;

public interface AdminService {
    int addCourses(Course c);
    int deleteCourse(Integer id);
    Course serachCourse(Integer id);

    int addUser(User u);
    User checkLogin(String usn, String psw);
    int searchUser(String username);
    User searchUserAndReturn(String username);
}
