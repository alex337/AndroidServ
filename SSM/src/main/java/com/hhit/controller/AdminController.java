package com.hhit.controller;

import com.hhit.model.Admin;
import com.hhit.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
    @Resource
    private AdminService adminservice;
    Admin admin=new Admin();
    @RequestMapping(value="/adminlogin")
    @ResponseBody
    public Map<String, Object> adminlogin(HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("查看中文名" + request.getParameter("userid"));
        System.out.println("密码" + request.getParameter("password"));
        if (request.getParameter("userid") == null) {
            map.put("msg", "wrong");
        } else {
            Admin admin2=new Admin();
            admin2=adminservice.selectByteaid(request.getParameter("userid"));
            if (admin2 == null) {
                map.put("msg", "wrong");
            } else {//用户存在于数据库
                if (admin2.getPassword().equals(request.getParameter("password"))) {//密码相等
                    HttpSession session = request.getSession();
                    session.setAttribute("userid", admin2.getUserid());
                    session.setAttribute("username", admin2.getUsername());
//                    session.setAttribute("loginname",student2.getLoginname());
                    System.out.println("新的获取session中的值" + request.getSession().getAttribute("userid"));
//                    session.setAttribute("user_id",student2.getId());
                    map.put("msg", "success");
                } else {//密码不等
                    map.put("msg", "wrong");
                }
            }
        }
        return map;
    }
    @RequestMapping(value="/adminupdatepwd")
    @ResponseBody
    public Map<String, Object> adminupdatepwd(HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        String userid=(String)session.getAttribute("userid");
        Admin admin=new Admin();
        admin.setUserid(userid);
        admin.setPassword(request.getParameter("password"));
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("password")==null){
            map.put("msg","修改信息失败，请重新修改");
        }
        else{
            adminservice.adminupdatepwd(admin);
            map.put("msg","信息修改成功，请重新登录");
        }
        return map;
    }

}
