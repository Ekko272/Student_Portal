package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminMainPageCont {
    @Autowired
    AdminService adminService;

    @RequestMapping(value="/addClassPage")
    public ModelAndView addClass(HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("addClass.html");
        mv.addObject("user",currentUser);
        return mv;
    }

    @RequestMapping(value="/deleteClassPage")
    public ModelAndView deleteClass(HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");

        ModelAndView mv = new ModelAndView("deleteClass");
        mv.addObject("user", currentUser);

        return mv;
    }

    @RequestMapping(value="/searchClassPage")
    public ModelAndView searchClass(HttpServletRequest request){
        HttpSession session = request.getSession();
        User currentUser = (User)session.getAttribute("currentUser");

        ModelAndView mv = new ModelAndView("searchClass");
        mv.addObject("user", currentUser);

        return mv;
    }

}
