package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Order;
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
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentAPI {
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;


    @PostMapping("/addCourseStu")
    public ResponseEntity<String> addClass(@RequestBody Integer courseId, HttpSession session){
        User user = (User)session.getAttribute("cruser");
        Course course = adminService.serachCourse(courseId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        if(course==null){
            return new ResponseEntity<>("Course Not Found",headers, HttpStatus.OK);
        }
        if(studentService.checkStudentHasCourse(user.getId(), courseId)){
            return new ResponseEntity<>("You already have this course",headers, HttpStatus.OK);
        }
        else {
            if(studentService.addCourse(user.getId(), adminService.serachCourse(courseId)) == 1)
            {
                String courseInfo = course.getName() + " by " + course.getInstructor()
                        + " has been added successfully";
                headers.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>(courseInfo,headers, HttpStatus.OK);
            }else {
                return new ResponseEntity<>("fail",headers,HttpStatus.OK);
            }
        }
    }

    @DeleteMapping(value = "/deleteCourseStu")
    public ResponseEntity<String> deleteClass(@PathVariable Integer id, HttpSession session){
        try {
            User user = (User)session.getAttribute("cruser");
            Course course = adminService.serachCourse(id);
            studentService.deleteCourse(user.getId(), course);

            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/makePayment")
//    public ResponseEntity<String> makePayment(@RequestBody Order order){
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.TEXT_PLAIN);
//        return new ResponseEntity<>("Cool", headers, HttpStatus.OK);
//
//    }

//    public double getTotalPrice(String tp){
//        String an = tp.replace("$","");
//        double result = Double.parseDouble(an);
//        return result;
//    }

    //TODO:
    // a) complete makePayment.html:
    // 1. User input for enterDate
    // 2. Retrieving data for enterDate and sent to here
    // b) Once successfully save the orders, send to Admin main page
    // let adimin deal with the orders and make approved to true

    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody List<Order> paymentData, HttpSession session) {

        User user = (User)session.getAttribute("cruser");
        int studentId = user.getId();
        Date currentDate = new Date();

        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());
        for(int i = 0; i < paymentData.size(); i++){
            paymentData.get(i).setPaymentDate(sqlDate);
            studentService.saveOrderPayment(studentId, paymentData.get(i));
        }
        return ResponseEntity.ok("ok");
    }





}
