package com.hhit.controller;

import com.hhit.model.Page;
import com.hhit.model.Teacher;
import com.hhit.model.Work;
import com.hhit.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value ="/teacher")
public class TeacherController {
    @Resource
    private TeacherService teacherservice;
    Teacher teacher=new Teacher();
    @RequestMapping(value = "/teacherlogin")
    @ResponseBody
    public Map<String,Object> teacherlogin(HttpServletRequest request) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println("查看中文名"+request.getParameter("userid"));
        System.out.println("密码"+request.getParameter("password"));
        if(request.getParameter("userid")==null){
            map.put("msg","wrong");
        }
        else{
            Teacher teacher2=new Teacher();
            teacher2=teacherservice.selectByteaid(request.getParameter("userid"));
            if(teacher2==null){
                //System.out.println("表示获取对象为空");
                map.put("msg","wrong");
            }
            else{//用户存在于数据库
                if(teacher2.getTeacherPwd().equals(request.getParameter("password"))){//密码相等
                    HttpSession session=request.getSession();
                    session.setAttribute("userid",teacher2.getTeacherID());
                    session.setAttribute("username",teacher2.getTeacherName());
//                    session.setAttribute("loginname",user2.getLoginname());
                    System.out.println("新的获取session中的值"+request.getSession().getAttribute("userid"));
//                    session.setAttribute("user_id",user2.getId());
                    map.put("msg","success");
                }
                else{//密码不等
                    map.put("msg","wrong");
                }
            }
        }
        return map;
    }
    @RequestMapping(value = "/teaupdatepwd")
    @ResponseBody
    public Map<String, Object> teaupdatepwd(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        String userid=(String)session.getAttribute("userid");
       teacher.setTeacherID(userid);
       teacher.setTeacherPwd(request.getParameter("password"));
//        user.setPassword(request.getParameter("password"));
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("password")==null){
            map.put("msg","修改信息失败，请重新修改");
        }
        else{
            teacherservice.teaupdatepwd(teacher);
//            userservice.updatepass(user);
            map.put("msg","信息修改成功，请重新登录");
        }
        return map;
    }
    @RequestMapping(value="/teaquery")
    public String teaquery(ModelMap modelMap){

        List<Teacher> tealist;
        tealist=teacherservice.teaSearchall();
        modelMap.addAttribute("tealist",tealist);
        return "teacherquery";
    }
    @RequestMapping(value= "/showteacher")
    public String showteacher(Page page, HttpServletRequest request) throws UnsupportedEncodingException {

        //组装page对象,传入方法中查询列表 回显数据
        Page p =page;
        int pageSize=8; //设置每页大小
        p.setPageSize(pageSize);
        int curPage=p.getCurrentPage();
        if (curPage==0) {
            curPage=1;
            p.setCurrentPage(curPage);
        }
        int startRow =page.getStartRow();
        if (!(p.getCurrentPage()==0)) {
            startRow = getStartRowBycurrentPage(curPage, pageSize);
        }
        p.setStartRow(startRow);
        List<Teacher> tealist = teacherservice.teaSearchall();
        Integer totalCounts = teacherservice.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("tealist", tealist);
        request.setAttribute("page", page);
        return "adminsearchtea";
    }

    public int getStartRowBycurrentPage(int currentPage,int pageSize){
        int startRow=0;
        if (currentPage==1) {
            return startRow=0; }
        startRow=(currentPage-1)*pageSize;
        return startRow;
    }
    @RequestMapping(value="/updatetea")
    public String updatetea(HttpServletRequest request)throws Exception{
        Teacher tea=new Teacher();
        tea=teacherservice.selectByteaname(request.getParameter("teaname"));
        tea.setTeacherID(request.getParameter("teaid"));
        tea.setTeacherCou(request.getParameter("teacou"));
        tea.setTeacherPwd(request.getParameter("password"));
        tea.setTeacherDep(request.getParameter("teadep"));
        tea.setTeacherTitle(request.getParameter("teatitle"));

        //System.out.println("这个地方获得ID的值看看"+user1.getId());
        teacherservice.updatetea(tea);
        return "redirect:/teacher/teaquery";
    }
    @RequestMapping(value="/deletetea")
    public String deletetea(HttpServletRequest request) throws Exception{
        System.out.println("id参数值获取"+request.getParameter("id"));
        int id=Integer.valueOf(request.getParameter("id"));
        teacherservice.deletetea(id);
        System.out.println("删除成功");
        return "redirect:/teacher/teaquery";
    }
    @RequestMapping(value="/addtea")
    public String addtea(Teacher teacher){
        //直接获取页面的传过来的对象进行值得添加
        teacherservice.addtea(teacher);
        return "redirect:/teacher/teaquery";
    }
}
