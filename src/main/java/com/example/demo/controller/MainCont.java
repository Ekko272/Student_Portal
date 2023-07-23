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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Controller()
public class MainCont extends HttpServlet {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AdminService adminService;
    @RequestMapping(value="/signIn", method = RequestMethod.GET)
    public ModelAndView signIn(HttpServletRequest request, String username, String password)
    {
        ModelAndView mv = new ModelAndView();
        String sql = "SELECT * FROM users WHERE username = ?;";
        List<Map<String, Object>> l = jdbcTemplate.queryForList(sql, username);

        boolean correct = false;
        boolean usernameExist = false;
        for (Map<String, Object> stringObjectMap : l) {
            if (Objects.equals(stringObjectMap.get("username").toString(), username)) {
                usernameExist = true;
                if (Objects.equals(stringObjectMap.get("password").toString(), password)) {
                    correct = true;
                    break;
                }
            }
        }
        if (correct) {
            mv.setViewName("redirect:/mainPage");
            //登录成功，创建session
            HttpSession session = request.getSession();
            String sql1 = "SELECT user_id FROM users WHERE username = ?;";
            List<Map<String, Object>> userIdMap = jdbcTemplate.queryForList(sql1, username);

            //创建user对象并保存到session作用域
            User u = new User(username, password, (int) userIdMap.get(0).get("user_id"));
            mv.setViewName("mainPage.html");
            session.setAttribute("currentUser", u);
            mv.addObject("username",u.getUserName());
        } else if (!usernameExist) {
            mv.setViewName("signIn.html");
            mv.addObject("alert", "Username doesn't exist");
        } else {
            mv.setViewName("signIn.html");
            mv.addObject("alert", "Incorrect password");
        }
        return mv;
    }

    @RequestMapping(value="/registerAccountPage")
    public ModelAndView registerAccount(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("registerAccount");

        return mv;
    }

    @PostMapping("/api/register")
    public ResponseEntity<String> register(@RequestBody User user)
    {
        User user1 = adminService.searchUser(user.getUserName());
        if(user1!=null)
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
}
