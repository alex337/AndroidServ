package com.hhit.controller;

import com.hhit.model.*;
import com.hhit.service.DocumentService;
import com.hhit.service.ResultService;
import com.hhit.service.StudentService;
import com.hhit.service.WorkService;
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
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value="/work")
public class WorkController {
    @Resource
    private WorkService workService;
    @Resource
    private StudentService studentService;
    @Resource
    private ResultService resultService;
    /**
     * 文件对象上传
     * @param request
     * @param work
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/addwork")
    public String upload1(HttpServletRequest request, @ModelAttribute Work work,
                          Model model) throws Exception{


        String term=request.getParameter("term");
        String sub=request.getParameter("sub");
        String stuClass=request.getParameter("queryCondition");
        Date date=new Date();
        System.out.println(date);
        work.setDate(date);
        List<String> stuid=studentService.stusearchlist();
        for (int i = 0; i < stuid.size(); i++) {

//            Result result=new Result();
//            result.setStuID(stuid.get(i));
//            result.setCoursename(sub);
//            result.setTerm(term);
//            result.setStuClass(stuClass);
//            resultService.addresult(result);
            System.out.println(stuid.get(i));
            work.setwName(request.getParameter("title"));
            work.setRemark(request.getParameter("remark"));
            work.setDate(date);
            work.setCoursename(sub);
            work.setStuID(stuid.get(i));
            work.setTerm(term);
            work.setStuClass(stuClass);
            HttpSession session=request.getSession();
            String username=(String)session.getAttribute("username");
            work.setUpuser(username);
            workService.addWork(work);
        }

        //System.out.println("看看get"+document.getFile());
//        if(!work.getFile().isEmpty()){
//            //获取一个上传文件的路径
//            String path="D:/file/work";
//            System.out.println("获取文件的上传路径"+path);
//            //上传文件名,获取源文件的原始名
//            String filename=work.getFile().getOriginalFilename();
//            //System.out.println("这个地方看看获取的文件名"+filename);
//            File filepath=new File(path,filename);
//            System.out.println("filepath的值"+filepath);
//            if(!filepath.getParentFile().exists()){
//                filepath.getParentFile().mkdirs();
//            }
//            //文件保存到目标文件中
//            work.getFile().transferTo(new File(path+File.separator+filename));
//            //System.out.println("看看get"+document.getFile());
//            work.setFilename(filename);//设置文件名
//            work.setFilepath(path);//设置文件存储地方
//            //下面开始数据库的信息操作
//            HttpSession session=request.getSession();
//            String username=(String)session.getAttribute("username");
//            //System.out.println("111111111111"+username);
//            work.setUpuser(username);
//            workService.addWork(work);
            //System.out.println("添加成功");
            model.addAttribute("work",work);
            return "teaupwork";
//        }else{
//            return "error";
//        }
    }
    /**
     * 文件的下载
     * @param request
     * @param filename
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/workdownload")
    public ResponseEntity<byte[]> workdownload(HttpServletRequest request, @RequestParam("filename")
            String filename, Model model) throws Exception{
        //下载文件的所在路径，至于下载到什么里边由浏览器默认配置
        String path="D:/file/work";
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

    /**
     * 文件的查询操作
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/workquery")
    public String workquery(ModelMap modelMap,HttpServletRequest request){

        List<Work> worklist;
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        Student student=studentService.selectBystuname(username);
        String id=student.getStuID();
        worklist=workService.workSearchall(id);
        modelMap.addAttribute("worklist",worklist);
        return "stuworkquery";
    }

    @RequestMapping(value="/deletework")
    public String deletework(HttpServletRequest request){
        int id=Integer.valueOf(request.getParameter("id"));
        //System.out.println("看看id值是什么"+id);
        String path=request.getServletContext().getRealPath("/work/");
        //System.out.println("path="+path);
        File file=new File(path+request.getParameter("filename"));
        if (file.exists()&&file.isFile())
        {
            file.delete();
            System.out.println("有没有到这一步呢");
            workService.deletework(id);
        }
        return "redirect:/work/workquery";
    }

    /**
     * 文档测试所用
     * @param request
     */
    @RequestMapping(value= "/selectwork")
    public String selectwork(Page page, HttpServletRequest request) throws UnsupportedEncodingException {

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
//        String queryCondition=null;
//        if (page.getQueryCondition()!=null) {
//            queryCondition = page.getQueryCondition();//查询条件
//        }
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        Student student=studentService.selectBystuname(username);/////
        String id=student.getStuID();
        List<Work> worklist = workService.workSearchall(id);
        Integer totalCounts = workService.searchTotalCount(page);//总条数
        int totalPages=(totalCounts%pageSize==0)?(totalCounts/pageSize):(totalCounts/pageSize+1);//总页数=总条数/页大小+1
        p.setTotalPage(totalPages);//总页数
        page.setTotalRows(totalCounts);//总行数
        request.setAttribute("worklist", worklist);
        request.setAttribute("page", page);
        return "studownwork";
    }
    public int getStartRowBycurrentPage(int currentPage,int pageSize){
        int startRow=0;
        if (currentPage==1) {
            return startRow=0; }
        startRow=(currentPage-1)*pageSize;
        return startRow;
    }

}
