package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class StudentAPI {
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;
    @PostMapping("/api/addCourseStu")
    public ResponseEntity<String> addClass(@RequestBody Integer courseId, HttpSession session){
        User user = (User)session.getAttribute("cruser");
        Course course = adminService.serachCourse(courseId);
        if(course==null){
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("Course Not Found",headers, HttpStatus.OK);
        }
        else {
            if(studentService.addCourse(user.getId(), adminService.serachCourse(courseId)) == 1)
            {
                String courseInfo = "Course " + course.getName() + "with instructor " + course.getInstructor()
                        + "has been added successfully";
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>(courseInfo,headers, HttpStatus.OK);
            }else {
                HttpHeaders hearderrs = new HttpHeaders();
                hearderrs.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>("fail",hearderrs,HttpStatus.OK);
            }
        }
    }

}
