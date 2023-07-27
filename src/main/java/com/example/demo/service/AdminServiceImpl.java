package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.model.Course;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
