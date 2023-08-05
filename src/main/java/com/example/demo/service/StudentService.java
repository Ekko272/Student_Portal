package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Order;

import java.util.List;

public interface StudentService {
    int addCourse(int studentId, Course course);
    boolean checkStudentHasCourse(int studentId, int courseId);
    int deleteCourse(int studentId, Course course);
    List<Course> findAllCourse();
    List<Integer> checkCoursesStudentHas(int id);
    List<Course> findAllCourseStudentHas(int id);
    List<Course> findAllNotApprovedCourseStudentHas(int id);
    int saveOrderPayment(int studentId, Order order);
    int setCourseApprovedOrNot(int studentId, int courseId, int choice);

}
