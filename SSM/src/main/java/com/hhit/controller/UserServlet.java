//package com.hhit.controller;
//
//import com.hhit.model.User;
//import com.hhit.service.UserService;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Controller
//@RequestMapping("/UserServlet")
//public class UserServlet {
//
//    @Resource
//    private UserService userService;
//    User user=new User();
//    @RequestMapping("/getUserById")
//    public void getUserById(HttpServletRequest request, HttpServletResponse response,int userid){
//        System.out.println("getUserById----------"+userid);
//
//    }
//
//    @RequestMapping("/test")
//    public String test(HttpServletRequest request, HttpServletResponse response){
//        String username=request.getParameter("username");
//
//        user=userService.selectByusername("cx");
//        System.out.println("user对象获取值的测试="+user.getPassword());
//        return "loginnew";
//    }
//
//}
