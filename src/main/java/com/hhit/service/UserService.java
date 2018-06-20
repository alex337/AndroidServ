package com.hhit.service;

import com.hhit.model.User;

import java.util.List;

public interface UserService {
    //按用户名查询用户测试
    User selectByusername(String username);
    //用户登陆部分
    User selectLogin(String username,String password);
    //用户登陆部分，对象形式传递
    User selectlogin(User user);
    //个人的信息修改
    void updatepass(User user);
    //查询用户集合
    List<User> userSearchall();
    //依据ID删除用户
    void deleteuser(int id);
    //添加用户
    void adduser(User user);
    //修改用户
    void updateuser(User user);

}
