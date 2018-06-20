package com.hhit.controller;
import com.hhit.model.User;
import com.hhit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping(value="/user")
public class UserController {
    @Resource
    private UserService userservice;
    User user=new User();
    /**
     * 测试部分模块
     * @return
     */
    @RequestMapping(value="/login1")
    public String test(){
        user=userservice.selectByusername("cx");
        System.out.println("springmvc测试成功！");
        System.out.println("测试数据库连接"+user.getLoginname());
        return "login";
    }
    /**
     * 处理用户登陆请求
     * @param user1 前台传递过来的对象
     * @param request session赋值
     * @param session
     * @return
     */
    @RequestMapping(value="/login")
    @ResponseBody
    public String login( User user1, HttpServletRequest request,HttpSession session){
        String msg="";
        User user2=userservice.selectByusername(user1.getUsername());
        if(user2==null){
            msg="wrong";
        }
        else{
            session=request.getSession();
            session.setAttribute("username",user2.getUsername());
            session.setAttribute("loginname",user2.getLoginname());
            System.out.println("获取session中的值"+request.getSession().getAttribute("username"));
            session.setAttribute("user_id",user2.getId());
            if(user1.getPassword().equals(user2.getPassword())){
                msg="right";
            }
            else{
                msg="wrong";
            }
        }
        return msg;
    }
    /**
     * 处理用户密码修改
     * @param request 获取界面参数
     * @param response
     * @return
     * @throws Exception 抛出异常
     */
    @RequestMapping(value="/updatepassword")
    @ResponseBody
    public Map<String, Object> updatepassword(HttpServletRequest request, HttpServletResponse response) throws Exception{
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        user.setUsername(username);
        user.setPassword(request.getParameter("password"));
        Map<String,Object> map=new HashMap<String, Object>();
        if(request.getParameter("password")==null){
            map.put("msg","修改信息失败，请重新修改");
        }
        else{
            userservice.updatepass(user);
            map.put("msg","信息修改成功，请重新登录");
        }
        return map;
    }

    /**
     * 新的登陆控制跳转，处理部分登陆错误问题。
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/loginnew")
    @ResponseBody
    public Map<String,Object> loginnew(HttpServletRequest request) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        System.out.println("查看中文名"+request.getParameter("username"));
        System.out.println("密码"+request.getParameter("password"));
        if(request.getParameter("username")==null){
            map.put("msg","wrong");
        }
        else{
            User user2=new User();
            user2=userservice.selectByusername(request.getParameter("username"));
            if(user2==null){
                //System.out.println("表示获取对象为空");
                map.put("msg","wrong");
            }
            else{//用户存在于数据库
                if(user2.getPassword().equals(request.getParameter("password"))){//密码相等
                    HttpSession session=request.getSession();
                    session.setAttribute("username",user2.getUsername());
                    session.setAttribute("loginname",user2.getLoginname());
                    System.out.println("新的获取session中的值"+request.getSession().getAttribute("username"));
                    session.setAttribute("user_id",user2.getId());
                    map.put("msg","success");
                }
                else{//密码不等
                    map.put("msg","wrong");
                }
            }
        }
        return map;
    }


    /**
     * 用户所有表的信息集合查询
     * @param modelMap 存储集合信息
     * @return
     */
    @RequestMapping(value="/userquery")
    public String userquery(ModelMap modelMap){
        List<User> userlist;
        userlist=userservice.userSearchall();
        modelMap.addAttribute("userlist",userlist);
        return "userquery";
    }

    /**
     * 处理数据删除
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/deleteuser")
    public String deleteuser(HttpServletRequest request) throws Exception{
        System.out.println("id参数值获取"+request.getParameter("id"));
        int id=Integer.valueOf(request.getParameter("id"));
        userservice.deleteuser(id);
        System.out.println("删除成功");

        return "redirect:/user/userquery.action";
    }

    /**
     * 多选删除功能实现
     * @param request
     * @return
     */
    @RequestMapping(value="/deletemore")
    public String deletemore(HttpServletRequest request){
        String[] userid=request.getParameterValues("selectname");
        if(userid.length>0){
            for(int i=0;i<userid.length;i++){
                userservice.deleteuser(Integer.parseInt(userid[i]));
            }
        }
        return "redirect:/user/userquery.action";
    }

    /**
     * 添加用户
     * @param user1
     * @return
     */
    @RequestMapping(value="/adduser")
    public String adduser(User user1){
        //直接获取页面的传过来的对象进行值得添加
        userservice.adduser(user1);
        return "redirect:/user/userquery.action";
    }

    /**
     * 修改用户信息
     * @param user1
     * @return
     */
    @RequestMapping(value="/updateuser")
    public String updateuser(User user1){
        //System.out.println("这个地方获得ID的值看看"+user1.getId());
        userservice.updateuser(user1);
        return "redirect:/user/userquery.action";
    }
    @RequestMapping(value="/tiaozhuan")
    public String tioazhuan(HttpServletRequest request,User user1){
        System.out.println("23123131231");
        System.out.println("对象获取用户名的值"+user1.getUsername());
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");
        System.out.println("string"+username);
        System.out.println("获取用户名的值"+(String)request.getSession().getAttribute("username"));

        //request.setAttribute("usernmae",request.getSession().getAttribute("username"));
        //System.out.println(session.getAttribute("usernmae"));
        return "main";
    }


}
