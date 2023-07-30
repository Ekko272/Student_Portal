package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServlet;
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
public class AdminAPI extends HttpServlet {
    @Autowired
    private AdminService adminService;

    @PostMapping("/api/addClass")//mapping地址为restful api post地址
    public ResponseEntity<String> addClass(@RequestBody Course c)//declare请求主体。Course c就是$http.post('/api/addClass',$scope.newClass)的$scope.newClass。
    {
        int result = adminService.addCourses(c);
        if(result == 1)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("success",headers, HttpStatus.OK);//传给restful response
        }else {
            HttpHeaders hearderrs = new HttpHeaders();
            hearderrs.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("fail",hearderrs,HttpStatus.OK);
        }
    }
    @PostMapping("/api/deleteClass")
    public ResponseEntity<String> deleteClass(@RequestBody Integer cid) {
        int result = adminService.deleteCourse(cid);
        if(result ==1)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("success",headers, HttpStatus.OK);//传给restful response
        }else {
            HttpHeaders hearderrs = new HttpHeaders();
            hearderrs.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("fail",hearderrs,HttpStatus.OK);
        }
    }

    @PostMapping("/api/searchClass")
    public ResponseEntity<Course> searchClass(@RequestBody Integer id) throws JsonProcessingException {
        Course course = adminService.serachCourse(id);
        //User cruser = (User)session.getAttribute("cruser");
        //Proved ResponseEntity method is able to pass a session
        if(course!=null)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return ResponseEntity.ok(course);
        }
        else{
            return ResponseEntity.ok(null);
        }
    }



}
