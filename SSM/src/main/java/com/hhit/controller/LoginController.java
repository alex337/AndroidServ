package com.hhit.controller;

import com.hhit.model.Student;
import com.hhit.service.StudentService;
import com.hhit.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
    @Resource
    private StudentService studentservice;
    private TeacherService teacherservice;

    @RequestMapping(value = "/loginnew")
    public String ModelAndView(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("查看中文名" + request.getParameter("userid"));
        System.out.println("密码" + request.getParameter("password"));
        System.out.println("单选框" + request.getParameter("list"));
        String radiovalue = request.getParameter("list");
        if (radiovalue.equals("学生")) {
            if (request.getParameter("userid") == null) {
                response.getWriter().write("用户名或密码不正确");
                return "loginnew";
            } else {
                Student student2 = new Student();
                student2 = studentservice.selectBystuid(request.getParameter("userid"));
                if (student2 == null) {
                    response.getWriter().write("用户名或密码不正确");
                    return "loginnew";
                } else {
                    if (student2.getStuPwd().equals(request.getParameter("password"))) {
                        HttpSession session = request.getSession();
                        session.setAttribute("userid", student2.getStuID());
                        session.setAttribute("stuname", student2.getStuName());
                        return "redirect:student";
                    } else {
                        response.getWriter().write("用户名或密码不正确");
                        return "loginnew";
                    }
                }
            }
        }
        return null;

    }
}

