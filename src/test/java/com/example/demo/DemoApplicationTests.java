package com.example.demo;

import com.example.demo.dao.AdminDao;
import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Objects;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    AdminService adminService;
    @Autowired
    AdminDao adminDao;

    @Test
    void contextLoads() {
    }


    @Test
    void checkLoginIn() {

        if(adminDao.checkLoginIn("a", "a")!=null){
            System.out.println("exist");
        }
        else{
            System.out.println("not exist or password wrong");
        }

    }
    @Test
    void searcgUser(){
        int i = adminDao.searchUser("aa");
        System.out.println(i);
    }

    @Test
    void addUser() {
        User u = new User("f","f");
        int i = adminDao.addUser(u);
        System.out.println(i);
    }
}
