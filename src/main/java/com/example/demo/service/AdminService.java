package com.example.demo.service;

import com.example.demo.model.Course;
import com.example.demo.model.Order;
import com.example.demo.model.User;

import java.util.List;

public interface AdminService {
    int addCourses(Course c);
    int deleteCourse(Integer id);
    Course serachCourse(Integer id);
    int addUser(User u);
    User checkLogin(String usn, String psw);
    int searchUser(String username);
    User searchUserAndReturn(String username);
    int StoreOrderPayment(int studentId, Order order);
    int approvePayment(Order order);
    int approvePaymentByOrderId(int orderId);
    List<Order> findAllOrderByStudentId(int studentId);
    List<Order> findAllOrderNotApproved();
    List<Order> findAllOrder();
    Order findOrderById(int orderId);
    int setCourseApprovedOrNot(int studentId, int courseId, int choice);

}
