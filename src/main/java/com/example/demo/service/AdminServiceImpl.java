package com.example.demo.service;

import com.example.demo.dao.AdminDao;
import com.example.demo.model.Course;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminDao adminDao;
    @Override
    public int addCourses(Course c) {
        return adminDao.addCourse(c);
    }

    @Override
    public int deleteCourse(Integer id) {
        if(adminDao.serachCourse(id) != null){
            return adminDao.deleteCourse(id);
        }
        else {
            return 0;
        }
    }

    @Override
    public Course serachCourse(Integer id) {
        return adminDao.serachCourse(id);
    }

    @Override
    public User searchUser(String username) {
        return adminDao.searchUser(username);
    }
}
