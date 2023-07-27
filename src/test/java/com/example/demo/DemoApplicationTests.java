package com.example.demo;

import com.example.demo.dao.BaseRepository;
import com.example.demo.model.Course;
import com.example.demo.model.Student;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Autowired
    AdminService adminService;
    @Autowired
    BaseRepository baseRepository;
    Course course1 = new Course(1,"1",2,3,"4","5",6,"5","8","8",5,"8","7","66",21);
    Course course2 = new Course(312,"5",2,3,"4","5",6,"5","8","8",5,"8","7","66",21);

    @Test
    void contextLoads() {
    }


    @Test
    void checkLoginIn() {

        if(baseRepository.checkLoginIn("a", "a")!=null){
            System.out.println("exist");
        }
        else{
            System.out.println("not exist or password wrong");
        }

    }
    @Test
    void searcgUser(){
        int i = baseRepository.searchUser("aa");
        System.out.println(i);
    }

    @Test
    void addUser() {
        User u = new User("f","f");
        int i = baseRepository.addUser(u);
        System.out.println(i);
    }

    @Test
    void teee(){
        Course course = baseRepository.serachCourse(525);
    }

    @Test
    void teeeeee(){

        Student student = new Student("aa","bb");
        student.addCourse(course1);
        student.addCourse(course2);
        System.out.println(student.toString());
    }

    @Test
    void asdads(){
        String sql = "SELECT course.id\n" +
                "FROM course\n" +
                "JOIN users_course ON course.id = users_course.course_id\n" +
                "WHERE users_course.users_id=?;";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, 3);
        List<Integer> coursesHave = new ArrayList<>();
        for(int i=0; i < maps.size();i++){
            Integer o = (Integer)maps.get(i).get("id");
            coursesHave.add(o);
        }
    }


}
