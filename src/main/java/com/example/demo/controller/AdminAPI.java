package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.model.Order;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
public class AdminAPI extends HttpServlet {
    @Autowired
    private AdminService adminService;

    @PostMapping("/api/addClass")//mapping地址为restful api post地址
    public ResponseEntity<String> addClass(@RequestBody Course c)//declare请求主体。Course c就是$http.post('/api/addClass',$scope.newClass)的$scope.newClass。
    {
        //ResponseEntity最多接受两个参数，一个@RequestBody，一个HTTPsession
        //从客户端传来的参数最多为一个object
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
    public ResponseEntity<Course> searchClass(@RequestBody Integer id, HttpSession session) throws JsonProcessingException {
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

    @PostMapping("/api/submit-orders")
    public ModelAndView submitOrders(@RequestParam Map<String, String> params, HttpSession session) {

        User currentUser = (User)session.getAttribute("cruser");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (entry.getKey().startsWith("approve_") && entry.getValue().equals("on")) {
                String orderId = entry.getKey().replace("approve_", "");
                int orderIdInt = Integer.parseInt(orderId);
                System.out.println("order ID has been approved: " + orderId);
                adminService.approvePaymentByOrderId(orderIdInt);
            }
        }

        ModelAndView mv = new ModelAndView("orderManagement");
        mv.addObject("user", currentUser);

        List<Order> allOrderNotApproved = adminService.findAllOrderNotApproved();
        if(allOrderNotApproved == null){
            mv.addObject("orderInfo", new String("No orders to deal with."));
        }
        else{
            mv.addObject("orderInfo", allOrderNotApproved);
        }
        return mv;
    }

}
