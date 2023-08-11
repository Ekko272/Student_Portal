package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.model.Course;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    BaseRepository baseRepository;

    @Override
    public int addCourses(Course c) {
        return baseRepository.addCourse(c);
    }

    @Override
    public int deleteCourse(Integer id) {
        Course course = baseRepository.serachCourse(id);
        if(course != null){
            return baseRepository.deleteCourse(id);
        }
        else {
            return 0;
        }
    }

    @Override
    public Course serachCourse(Integer id) {
        return baseRepository.serachCourse(id);
    }

    @Override
    public int addUser(User u) {
        return baseRepository.addUser(u);
    }

    @Override
    public User checkLogin(String usn, String psw) {
        return baseRepository.checkLoginIn(usn,psw);
    }

    @Override
    public int searchUser(String username) {
        return baseRepository.searchUser(username);
    }

    @Override
    public User searchUserAndReturn(String username) {
        return baseRepository.searchUserAndReturn(username);
    }

    @Override
    public int StoreOrderPayment(int studentId, Order order) {
        return 0;
    }

    @Override
    public int approvePayment(Order order) {
        return baseRepository.approvePayment(order);
    }

    @Override
    public int approvePaymentByOrderId(int orderId) {
        return baseRepository.approvePaymentByOrderId(orderId);
    }

    @Override
    public List<Order> findAllOrderByStudentId(int studentId) {
        return baseRepository.findAllOrderByStudentId(studentId);
    }

    @Override
    public List<Order> findAllOrderNotApproved() {
        return baseRepository.findAllOrderNotApproved();
    }

    @Override
    public List<Order> findAllOrder() {
        return baseRepository.findAllOrder();
    }

    @Override
    public Order findOrderById(int orderId) {
        return baseRepository.findOrderById(orderId);
    }

    @Override
    public int setCourseApprovedOrNot(int studentId, int courseId, int choice) {
        return baseRepository.setCourseApprovedOrNot(studentId,courseId,choice);
    }


}
