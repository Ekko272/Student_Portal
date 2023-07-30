package com.example.demo.service;

import com.example.demo.model.Course;

import java.util.List;

public interface StudentService {
    int addCourse(int studentId, Course course);
    boolean checkStudentHasCourse(int studentId, int courseId);
    int deleteCourse(int studentId, Course course);
    List<Course> findAllCourse();
}
