package com.example.demo;

import com.example.demo.dao.AdminDao;
import com.example.demo.model.Course;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    AdminService adminService;
    @Test
    void contextLoads() {
    }


    @Test
    void deleteCourse() {
        System.out.println(adminService.deleteCourse(1));
    }
}
