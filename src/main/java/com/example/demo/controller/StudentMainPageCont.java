package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentMainPageCont {
    @Autowired
    StudentService studentService;
    @GetMapping(value="/browseAllClassPage")
    public ModelAndView browseAllClass(HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("cruser");
        ModelAndView mv = new ModelAndView("browseAllClass");
        mv.addObject("user",currentUser);
        List<Course> allCourse = studentService.findAllCourse();
        mv.addObject("allCourse", allCourse);
        return mv;
    }
}
