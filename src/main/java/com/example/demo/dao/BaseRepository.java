package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.User;

import java.util.List;

public interface BaseRepository {
    int addCourse(Course c);
    Course serachCourse(Integer id);
    int deleteCourse(Integer id);
    int searchUser(String username);
    int addUser(User user);
    User checkLoginIn(String username, String password);
    User searchUserAndReturn(String username);
    int studentAddCourse(int studentId,Course c);
    int studentDeleteCourse(int studentId,Course c);
    List<Integer> checkCoursesStudentHas(int id);
    void incEnrollment(Integer id);
    void decEnrollment(Integer id);



}
