package com.example.demo.service;

import com.example.demo.model.Course;

public interface StudentService {
    int addCourse(int studentId, Course course);
    boolean checkStudentHasCourse(int studentId, int courseId);
    int deleteCourse(int studentId, Course course);
}
