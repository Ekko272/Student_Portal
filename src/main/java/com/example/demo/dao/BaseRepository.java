package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.Order;
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
    void setPaid(int choice, int studentId, int courseId);
    List<Course> findAllCourse();
    List<Course> findAllCourseStudentHas(int id);
    List<Course> findAllNotApprovedCourseStudentHas(int id);
    List<Course> findAllNotPaidCourseStudentHas(int studentId);
    int saveOrderPayment(int studentId, Order order);
    int approvePayment(Order order);
    int approvePaymentByOrderId(int orderId);
    List<Order> findAllOrderByStudentId(int studentId);
    List<Order> findAllOrderNotApproved();
    List<Order> findAllOrder();
    Order findOrderById(int orderId);
    int setCourseApprovedOrNot(int studentId, int courseId, int choice);



}
