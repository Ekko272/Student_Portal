package com.example.demo.controller;

import com.example.demo.model.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="/mainPage", method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletRequest request){
        ModelAndView mv = new ModelAndView("mainPage.html");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("currentUser");
        if (user == null) {
            mv.setViewName("redirect:/signIn");
            return mv;
        }

        return mv;
    }
}
