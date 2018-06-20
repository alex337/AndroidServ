package com.hhit.controller;

import com.hhit.model.*;
import com.hhit.service.*;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/stuwork")
public class StuWorkController {
    @Resource
    private StuWorkService stuworkService;
    @Resource
    private AssessService assessService;
    @Resource
    private WorkService workService;
    @Resource
    private StudentService studentService;
    @Resource
    private TeacherService teacherService;
    @Resource
    private ResultService resultService;
    @Resource
    private CourseService courseService;
    /**
     * 文件对象上传
     * @param request
     * @param stuwork
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addstuwork")
    public String upload1(HttpServletRequest request, @ModelAttribute StuWork stuwork,
                          Model model) throws Exception{

        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        String userid=(String)session.getAttribute("userid");
        String wName=(String)session.getAttribute("wName");
        String coursename=(String)session.getAttribute("coursename");
        String term=(String)session.getAttribute("term");

        System.out.println("陈鑫"+term+""+coursename);
        Date date=new Date();
        System.out.println(date);
        stuwork.setDate(date);
        stuwork.setStatus("已交");
        stuwork.setwName(wName);
        stuwork.setCoursename(coursename);
        stuwork.setTerm(term);
        stuwork.setRemark(request.getParameter("remark"));
        Work work=workService.selectnameid(wName,userid,coursename,term);
        String remark=work.getRemark();
        String teacherName=work.getUpuser();
        String stuClass=work.getStuClass();
        stuwork.setRemark(remark);
        stuwork.setTeacherName(teacherName);
        stuwork.setStuClass(stuClass);
        workService.deleteworkbyname(wName,userid,coursename,term);

        if(!stuwork.getFile().isEmpty()){
            //获取一个上传文件的路径
            String path="C:/file/stuwork";
            System.out.println("获取文件的上路径"+path);
            //上传文件名,获取源文件的原始名
            String filename=stuwork.getFile().getOriginalFilename();
            //System.out.println("这个地方看看获取的文件名"+filename);
            File filepath=new File(path,filename);
            System.out.println("filepath的值"+filepath);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //文件保存到目标文件中
            stuwork.getFile().transferTo(new File(path+File.separator+filename));
            //System.out.println("看看get"+document.getFile());
            stuwork.setFilename(filename);//设置文件名
            stuwork.setFilepath(path);//设置文件存储地方
            //下面开始数据库的信息操作

            //System.out.println("111111111111"+username);
            stuwork.setStuname(username);
            stuwork.setStuID(userid);
            stuworkService.addStuWork(stuwork);
            System.out.println("添加成功");
            model.addAttribute("stuwork",stuwork);
            return "redirect:/work/workquery";
        }else{
            return "error";
        }
    }
    @RequestMapping(value="/stuworkquery")
    public String stuworkquery(ModelMap modelMap,HttpServletRequest request){

        List<StuWork> stuworklist;
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        stuworklist=stuworkService.stuworktea(username);
        System.out.println("cxxx"+username);
        modelMap.addAttribute("stuworklist",stuworklist);
        return "teaquerystuwork";
    }
    @RequestMapping(value="/searchfinish")
    public String searchfinish(ModelMap modelMap,HttpServletRequest request){

        List<StuWork> stuworklist;
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        Student student=studentService.selectBystuname(username);
        String stuid=student.getStuID();
        stuworklist=stuworkService.selecfinish(stuid,"已评价");
        modelMap.addAttribute("stuworklist",stuworklist);
        return "stuworkfinish";
    }
    /**
     * 文件的下载
     * @param request
     * @param filename
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/stuworkdownload")
    public ResponseEntity<byte[]> workdownload(HttpServletRequest request, @RequestParam("filename")
            String filename, Model model) throws Exception{
        //下载文件的所在路径，至于下载到什么里边由浏览器默认配置
        String path="C:/file/stuwork";
        System.out.println("获取path的值"+path);
        File file=new File(path+File.separator+filename);
        HttpHeaders headers=new HttpHeaders();
        //下载显示的文件名+解决中文乱码问题
        String downloadfIlename=new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以下载方法打开文件
        headers.setContentDispositionFormData("attachment",downloadfIlename);
        //二进制流数据转换文件下载
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //201HttpStatus.CREATED
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
    @RequestMapping(value= "/showstuwork")
    public String showstuwork(Page page, HttpServletRequest request) throws UnsupportedEncodingException {

        //组装page对象,传入方法中查询列表 回显数据
        Page p =page;
        int pageSize=10; //设置每页大小
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
        List<StuWork> stuworklist = stuworkService.stuworkSearchall();
        Integer totalCounts = stuworkService.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("stuworklist", stuworklist);
        request.setAttribute("page", page);
        return "teadownwork";
    }
    public int getStartRowBycurrentPage(int currentPage,int pageSize){
        int startRow=0;
        if (currentPage==1) {
            return startRow=0; }
        startRow=(currentPage-1)*pageSize;
        return startRow;
    }
    @RequestMapping(value= "/assstuwork")
    public String assstuwork(ModelMap modelMap,HttpServletRequest request){
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        String stuid=(String)session.getAttribute("stuid");
        String stuname=(String)session.getAttribute("stuname");
        String filename=(String)session.getAttribute("filename");
        String coursename=(String)session.getAttribute("coursename");
        String term=(String)session.getAttribute("term");
        String wName=(String)session.getAttribute("wName");
        String comment=request.getParameter("assess");
        String score=request.getParameter("score");
        String show=request.getParameter("isshow");
        StuWork stuWork=stuworkService.selectnameid(wName,stuid,coursename,term);
        stuWork.setAssess(comment);
        stuWork.setScore(score);
        stuworkService.stuupdateass(stuWork);
        System.out.println(show);
        if(show.equals("1")){
            //work增加
            Date date=new Date();
            Work work=new Work();
            work.setDate(date);
            work.setRemark(stuWork.getRemark());
            work.setStuID(stuWork.getStuID());
            work.setwName(stuWork.getwName());
            work.setCoursename(stuWork.getCoursename());
            work.setUpuser(username);
            work.setStuClass(stuWork.getStuClass());
            workService.addWork(work);
            stuWork.setStatus("未交");
            stuworkService.stuupdatesta(stuWork);
        }else{
            stuWork.setStatus("已评价");
            stuworkService.stuupdatesta(stuWork);
        }




        List<StuWork> stuworklist;
        stuworklist=stuworkService.stuworktea(username);
        modelMap.addAttribute("stuworklist",stuworklist);
        return "teaquerystuwork";
    }
    @RequestMapping(value= "/stuworkfinish")
    public String stuworkfinish(ModelMap modelMap,HttpServletRequest request){
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        Student student=studentService.selectBystuname(username);
        String stuid=student.getStuID();
        String status="已评价";
        List<StuWork> stuworklist=stuworkService.selecfinish(stuid,"已评价");
        modelMap.addAttribute("stuworklist",stuworklist);
        return "stuworkfinish";

    }
    @RequestMapping(value= "/selectresult")
    public String selectresult(ModelMap modelMap,HttpServletRequest request){
        String stuClass=request.getParameter("stuClass");
        String coursename=request.getParameter("coursename");
        String term=request.getParameter("term");
        List<Result> resultlist=resultService.selectresult(stuClass,coursename,term);
        List<StuWork> stuworklist=stuworkService.selectgrade(stuClass,coursename,term);
        modelMap.addAttribute("resultlist", resultlist);
        modelMap.addAttribute("stuworklist", stuworklist);
      return "result";

    }
    @RequestMapping(value="/selectclass")
    public String selectclass(HttpServletRequest request,ModelMap modelMap){
        HttpSession session=request.getSession();
        String teacherName=(String)session.getAttribute("username");
        List<String> classlist=studentService.selectclass();
        List<String> courselist=courseService.selectcourse(teacherName);
        modelMap.addAttribute("classlist",classlist);
        modelMap.addAttribute("courselist",courselist);
        return "selectresult";
    }


}
