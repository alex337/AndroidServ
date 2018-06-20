package com.hhit.controller;

import com.hhit.model.Page;
import com.hhit.model.Result;
import com.hhit.model.Student;
import com.hhit.service.CourseService;
import com.hhit.service.ResultService;
import com.hhit.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value="/student")
public class StudentController {
    @Resource
    private StudentService studentservice;
    @Resource
    private CourseService courseService;
    @Resource
    private ResultService resultService;
    Student student = new Student();

    @RequestMapping(value="/stulogin")
    @ResponseBody
    public Map<String, Object> stulogin(HttpServletRequest request) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        System.out.println("查看中文名" + request.getParameter("userid"));
        System.out.println("密码" + request.getParameter("password"));
        if (request.getParameter("userid") == null) {
            map.put("msg", "wrong");
        } else {
            Student student2 = new Student();
            student2 = studentservice.selectBystuid(request.getParameter("userid"));
            if (student2 == null) {
                map.put("msg", "wrong");
            } else {//用户存在于数据库
                if (student2.getStuPwd().equals(request.getParameter("password"))) {//密码相等
                    HttpSession session = request.getSession();
                    session.setAttribute("userid", student2.getStuID());
                    session.setAttribute("username", student2.getStuName());
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
    @RequestMapping(value="/stuupdatepwd")
    @ResponseBody
    public Map<String, Object> stuupdatepwd(HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        String stuID=(String)session.getAttribute("userid");

        Student stu=new Student();


        stu.setStuID(stuID);
        System.out.println(stuID);
        stu.setStuPwd(request.getParameter("password"));
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("password")==null){
            map.put("msg","修改信息失败，请重新修改");
        }
        else{
            studentservice.stuupdatepass(stu);
            map.put("msg","信息修改成功，请重新登录");
        }
        return map;
    }
    @RequestMapping(value="/selectbyname")
    public String selectbyname(ModelMap modelMap,HttpServletRequest request) throws Exception{
        String stuname=request.getParameter("sname");
        Student student;
        student=studentservice.selectBystuname(stuname);
        modelMap.addAttribute("student",student);
        return "stuquery";
    }
    @RequestMapping(value="/querystu")
    public String querystu(ModelMap modelMap,HttpServletRequest request){

        List<Student> stulist;
        HttpSession session=request.getSession();
        String stuClass=(String) session.getAttribute("stuClass");
        stulist=studentservice.searchabsence(stuClass);
        modelMap.addAttribute("stulist",stulist);
        return "teasearchstu";
    }
    @RequestMapping(value="/stuquery")
    public String stuquery(ModelMap modelMap){

        List<Student> stulist;
        stulist=studentservice.stuSearchall();
        modelMap.addAttribute("stulist",stulist);
        return "studentquery";
    }
//    @RequestMapping(value="/selectbyclass")
//    public String selectbyclass(ModelMap modelMap,HttpServletRequest request,Integer page) throws Exception{
//        String class1=request.getParameter("selectclass");
//        List<Student> stulist;
//
//        stulist=studentservice.selectBystuclass(class1);
//        int count=stulist.size();
//        PagingVO pagingVO = new PagingVO();
//        pagingVO.setTotalCount(studentservice.getCountstuclass(class1));
//        if (page == null || page == 0) {
//            pagingVO.setToPageNo(1);
//            stulist = studentservice.findByPaging(1);
//        } else {
//            pagingVO.setToPageNo(page);
//            stulist = studentservice.findByPaging(page);
//        }
//        modelMap.addAttribute("stulist",stulist);
//        modelMap.addAttribute("pagingVO",pagingVO);
//        return "stuquery";
//    }
//    @RequestMapping(value= "/stushow")
//    public String stushow(ModelMap modelMap,Integer page) throws Exception{
//        List<Student> stulist=null;
//        PagingVO pagingVO = new PagingVO();
//        pagingVO.setTotalCount(studentservice.getCountStudent());
//        if (page == null || page == 0) {
//            pagingVO.setToPageNo(1);
//            stulist =studentservice.findByPaging(1);
//        } else {
//            pagingVO.setToPageNo(page);
//            stulist = studentservice.findByPaging(page);
//        }
//        modelMap.addAttribute("stulist",stulist);
//        modelMap.addAttribute("pagingVO",pagingVO);
//        return "stuquery";
//    }
    @RequestMapping("/main")
    public String  main(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,ModelMap modelMap){
        modelMap.addAttribute("pagemsg", studentservice.findByPage(currentPage));//回显分页数据
        return "stuquery";
    }
//    @RequestMapping(value= "/selectbyclass")
//    public String selectbyclass(@RequestParam(value="currentPage",defaultValue="1",required=false)int currentPage,ModelMap modelMap,HttpServletRequest request){
//        String class1=request.getParameter("selectclass");
//        modelMap.addAttribute("pagemsg", studentservice.findByclass(class1,currentPage));//回显分页数据
//        return "stuquery";
//    }
    @RequestMapping(value= "/selectbyclass")
    public String selectbyclass(Page page, HttpServletRequest request) throws UnsupportedEncodingException {

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
        String queryCondition=request.getParameter("queryCondition");
//        if (page.getQueryCondition()!=null) {
//            queryCondition = page.getQueryCondition();//查询条件
//        }
        page.setQueryCondition(queryCondition);
        String date=request.getParameter("date");
        HttpSession session=request.getSession();
        session.setAttribute("condition",queryCondition);//
        session.setAttribute("date",date);//
        String term=request.getParameter("term");
        String sub=request.getParameter("sub");
        session.setAttribute("term",term);
        session.setAttribute("coursename",sub);
        System.out.println("cx12"+queryCondition);
        List<Student> stulist = getstuListByCondition(page);
        Integer totalCounts = studentservice.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("stulist", stulist);
        request.setAttribute("page", page);
        return "stusearchresult";
    }
    public int getStartRowBycurrentPage(int currentPage,int pageSize){
        int startRow=0;
        if (currentPage==1) {
            return startRow=0; }
        startRow=(currentPage-1)*pageSize;
        return startRow;
    }
    private List<Student> getstuListByCondition(Page page) {
        List<Student> stulist =null;
        if (page.getQueryCondition()==null) {
            stulist = studentservice.searchstuList(page);
            return stulist;
        }
       stulist = studentservice.getstuBycondtion(page);
        return stulist;
    }
    @RequestMapping(value= "/showstu")
    public String showstu(Page page, HttpServletRequest request) throws UnsupportedEncodingException {

        //组装page对象,传入方法中查询列表 回显数据
        Page p =page;
        int pageSize=5; //设置每页大小
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
//        String queryCondition=null;
//        if (page.getQueryCondition()!=null) {
//            queryCondition = page.getQueryCondition();//查询条件
//        }
        List<Student> stulist = studentservice.stuSearchall();
        Integer totalCounts = studentservice.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("stulist", stulist);
        request.setAttribute("page", page);
        return "studentsearch";
    }
    @RequestMapping(value="/updatestu")
    public String updatestu(HttpServletRequest request)throws Exception{
        Student stu=new Student();
        stu=studentservice.selectBystuname(request.getParameter("stuname"));
        stu.setStuID(request.getParameter("stuid"));
        stu.setStuClass(request.getParameter("stuclass"));
        stu.setStuPwd(request.getParameter("password"));
        //System.out.println("这个地方获得ID的值看看"+user1.getId());
        studentservice.updatestu(stu);
        return "redirect:/student/stuquery";
    }
    @RequestMapping(value="/deletestu")
    public String deletestu(HttpServletRequest request) throws Exception{
        System.out.println("id参数值获取"+request.getParameter("id"));
        int id=Integer.valueOf(request.getParameter("id"));
        studentservice.deletestu(id);
        System.out.println("删除成功");

        return "redirect:/student/stuquery";
    }
    @RequestMapping(value="/addstu")
    public String addstu(Student student){
        //直接获取页面的传过来的对象进行值得添加
        studentservice.addstu(student);
        return "redirect:/student/stuquery";
    }
    @RequestMapping(value="/selectstudent")
    public String selectstudent(HttpServletRequest request,ModelMap modelMap){
        //直接获取页面的传过来的对象进行值得添加
        String date=request.getParameter("date");
        HttpSession session=request.getSession();
        session.setAttribute("date",date);//
        String term=request.getParameter("term");
        String sub=request.getParameter("sub");
        session.setAttribute("term",term);
        session.setAttribute("coursename",sub);
        String stuClass=request.getParameter("queryCondition");
        session.setAttribute("stuClass",stuClass);
        List<Student> stulist=studentservice.selectstudent(stuClass);
        studentservice.updatestatus();
        modelMap.addAttribute("stulist",stulist);

        return "selectstudent";
    }
    @RequestMapping(value="/stucall")
    public String stucall(Page page,HttpServletRequest request) {
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
        String queryCondition=null;
        HttpSession session=request.getSession();
        queryCondition=(String) session.getAttribute("condition");
        System.out.println("cx"+queryCondition);
        page.setQueryCondition(queryCondition);
        List<Student> stulist = getstuListByCondition(page);
        Integer totalCounts = studentservice.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("stulist", stulist);
        request.setAttribute("page", page);
        Student stu=new Student();
        stu=studentservice.selectBystuid(request.getParameter("id"));
        //stu.setStuID(request.getParameter("id"));
        String status="未到";
        stu.setStuStatus(status);
        int absence=stu.getStuAbsence();
        System.out.println("cx12"+absence);
        int abs=absence+1;
        String term=(String)session.getAttribute("term");
        String coursename=(String)session.getAttribute("coursename");
        System.out.println("时间"+term);
        String stuID=stu.getStuID();
        Result result=resultService.selectres(stuID,coursename,term);
        result.setAbsence(abs);
        resultService.updateabs(result);
        String date=(String)session.getAttribute("date");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1= (Date)sf.parseObject(date);
        try {
            Date date1= (Date)sf.parseObject(date);
            stu.setDate(date1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println("cxsaa"+abs);

        stu.setStuAbsence(abs);
        studentservice.stucall(stu);
        return "stusearchresult";
    }
    @RequestMapping(value="/stucall2")
    public String stucall2(Page page,HttpServletRequest request) {
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
        String queryCondition=null;
        HttpSession session=request.getSession();
        queryCondition=(String) session.getAttribute("condition");
        System.out.println("cx"+queryCondition);
        page.setQueryCondition(queryCondition);
        List<Student> stulist = getstuListByCondition(page);
        Integer totalCounts = studentservice.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("stulist", stulist);
        request.setAttribute("page", page);
        Student stu=new Student();
        stu=studentservice.selectBystuid(request.getParameter("id"));
        //stu.setStuID(request.getParameter("id"));
        stu.setStuStatus("已到");
        int absence=stu.getStuAbsence();
        System.out.println("cx12"+absence);
        stu.setStuAbsence(absence);
        studentservice.stucall(stu);
        return "stusearchresult";
    }
    @RequestMapping(value="/stucall3")
    public String stucall3(HttpServletRequest request,ModelMap modelMap){
        Student stu=new Student();
        stu=studentservice.selectBystuid(request.getParameter("id"));
        String status="未到";
        stu.setStuStatus(status);
        int absence=stu.getStuAbsence();
        int abs=absence+1;
        HttpSession session=request.getSession();
        String term=(String)session.getAttribute("term");
        String coursename=(String)session.getAttribute("coursename");
        String stuID=stu.getStuID();
        Result result=resultService.selectres(stuID,coursename,term);
        result.setAbsence(abs);
        resultService.updateabs(result);
        String date=(String)session.getAttribute("date");
        result.setDay(date);
        resultService.updatedate(result);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1= (Date)sf.parseObject(date);
        try {
            Date date1= (Date)sf.parseObject(date);
            stu.setDate(date1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String stuClass=(String)session.getAttribute("stuClass");
        List<Student> stulist=studentservice.selectstudent(stuClass);
        modelMap.addAttribute("stulist",stulist);

        stu.setStuAbsence(abs);
        studentservice.stucall(stu);
        return "selectstudent";


    }
    @RequestMapping(value="/stucall4")
    public String stucall4(HttpServletRequest request,ModelMap modelMap){
        Student stu=new Student();
        stu=studentservice.selectBystuid(request.getParameter("id"));
        String status="已到";
        stu.setStuStatus(status);
        int absence=stu.getStuAbsence();
        HttpSession session=request.getSession();
        String term=(String)session.getAttribute("term");
        String coursename=(String)session.getAttribute("coursename");
        String stuID=stu.getStuID();
        Result result=resultService.selectres(stuID,coursename,term);
        result.setAbsence(absence);
        resultService.updateabs(result);
        String date=(String)session.getAttribute("date");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date1= (Date)sf.parseObject(date);
        try {
            Date date1= (Date)sf.parseObject(date);
            stu.setDate(date1);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String stuClass=(String)session.getAttribute("stuClass");
        List<Student> stulist=studentservice.selectstudent(stuClass);
        modelMap.addAttribute("stulist",stulist);
        stu.setStuAbsence(absence);
        studentservice.stucall(stu);
        return "selectstudent";


    }
    @RequestMapping(value="/searchabsence")
    public String searchabsence(HttpServletRequest request){
        String queryCondition=null;
        HttpSession session=request.getSession();
        queryCondition=(String) session.getAttribute("condition");
        List<Student> stulist=studentservice.searchabsence(queryCondition);
        if(stulist.size()==0){
            return "stunoabs";
        }else {
            request.setAttribute("stulist", stulist);
            return "stusearchabs";
        }

    }
    @RequestMapping(value="/stuabsence")
    public String stuabsence(HttpServletRequest request){
        String queryCondition=null;
        HttpSession session=request.getSession();
        queryCondition=(String) session.getAttribute("condition");
        List<Student> stulist=studentservice.absence(queryCondition);
        request.setAttribute("stulist", stulist);
        studentservice.updatestatus();
        return "stuabsence";


    }
    @RequestMapping(value="/selectclass")
    public String  selectclass(HttpServletRequest request,ModelMap modelMap){
        HttpSession session=request.getSession();
        String teacherName=(String)session.getAttribute("username");
        List<String> classlist=studentservice.selectclass();
        List<String> courselist=courseService.selectcourse(teacherName);
//        for (int i = 0; i < courselist.size(); i++) {
//            System.out.println(courselist.get(i));
//        }

        modelMap.addAttribute("classlist",classlist);
        modelMap.addAttribute("courselist",courselist);
        return "stusearch";


    }

    @RequestMapping(value="/teaupwork")
    public String  teaupwork(HttpServletRequest request,ModelMap modelMap){
        HttpSession session=request.getSession();
        String teacherName=(String)session.getAttribute("username");
        List<String> classlist=studentservice.selectclass();
        List<String> courselist=courseService.selectcourse(teacherName);
        modelMap.addAttribute("classlist",classlist);
        modelMap.addAttribute("courselist",courselist);
        return "teaupwork";
    }

    @RequestMapping(value="/selectcour")
    public String  selectcour(HttpServletRequest request,ModelMap modelMap){
        HttpSession session=request.getSession();
        String teacherName=(String)session.getAttribute("username");
        List<String> courselist=courseService.selectcourse("纪兆辉");
        modelMap.addAttribute("courselist",courselist);
        return "selectabs";


    }
    @RequestMapping(value="/selectabs")
    public String  selectabs(HttpServletRequest request,ModelMap modelMap){
        HttpSession session=request.getSession();
        String term=request.getParameter("term");
        String coursename=request.getParameter("coursename");
        String stuID=(String)session.getAttribute("userid");
        Result result=resultService.selectabs(stuID,coursename,term);
        String date=result.getDay();
        int num=result.getAbsence();
        String[] array = date.split(" ");
        List datelist = java.util.Arrays.asList(array);

        System.out.println(array.length);//结果是5，而不是预想中的8
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

        modelMap.addAttribute("datelist",datelist);
        modelMap.addAttribute("num",num);
        modelMap.addAttribute("coursename",coursename);
        return "absresult";


    }


}
