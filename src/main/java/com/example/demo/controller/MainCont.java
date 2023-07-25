package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.service.AdminService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller()
public class MainCont extends HttpServlet {
    @Autowired
    AdminService adminService;
    @RequestMapping(value="/signIn", method = RequestMethod.GET)
    public ModelAndView signIn(HttpServletRequest request, String username, String password)
    {
        try{
        ModelAndView mv = new ModelAndView();
        User user = adminService.checkLogin(username, password);
        if (user!=null){
            if(user.getId()==1) {
                mv.setViewName("redirect:/mainPage");
                HttpSession session = request.getSession();
                mv.setViewName("mainPage.html");
                session.setAttribute("cruser", user);
                mv.addObject("username", username);
                return mv;
            }
            else{
                mv.setViewName("redirect:/studentMainPage");
                HttpSession session = request.getSession();
                mv.setViewName("studentMainPage.html");
                session.setAttribute("cruser", user);
                mv.addObject("username", username);
                return mv;
            }
        }
        else {
            mv.setViewName("signIn.html");
            if(username!=null) {
                mv.addObject("alert", "Username doesn't exist or Incorrect password");
            }
            return mv;
        }
        }catch(Throwable e) {
            e.printStackTrace();
            return null;
        }
    }

    @RequestMapping(value="/registerAccountPage")
    public ModelAndView registerAccount(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("registerAccount");
        return mv;
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody User user)
    {
        User user1 = adminService.searchUserAndReturn(user.getUserName());
        if(user1!=null)
        {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.TEXT_PLAIN);
            return new ResponseEntity<>("Username already exist",headers, HttpStatus.OK);//传给restful response
        }else {
            int i = adminService.addUser(user);
            if(i>0) {
                HttpHeaders hearderrs = new HttpHeaders();
                hearderrs.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>("Register Success!", hearderrs, HttpStatus.OK);
            }
            else{
                HttpHeaders hearderrrs = new HttpHeaders();
                hearderrrs.setContentType(MediaType.TEXT_PLAIN);
                return new ResponseEntity<>("Register Fail!", hearderrrs, HttpStatus.OK);
            }
        }
    }
}
