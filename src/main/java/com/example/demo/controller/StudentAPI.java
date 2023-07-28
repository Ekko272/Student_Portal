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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        if(course==null){

            return new ResponseEntity<>("Course Not Found",headers, HttpStatus.OK);
        }
        if(studentService.checkStudentHasCourse(user.getId(), courseId)){
            return new ResponseEntity<>("Already Has this course",headers, HttpStatus.OK);
        }
        else {
            if(studentService.addCourse(user.getId(), adminService.serachCourse(courseId)) == 1)
            {
                String courseInfo = "Course " + course.getName() + "with instructor " + course.getInstructor()
                        + "has been added successfully";
                headers.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>(courseInfo,headers, HttpStatus.OK);
            }else {

                return new ResponseEntity<>("fail",headers,HttpStatus.OK);
            }
        }
    }

}
