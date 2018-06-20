package com.hhit.dao;

import com.hhit.model.User;

import java.util.List;

public interface UserDao {
    User selectByusername(String username);//被调用按用户名查询用户内容
    User selectLogin(String username,String password);//用户登陆
    User selectlogin(User user);//用户登陆传递对象
    void updatepass(User user);//用户密码修改
    List<User> userSearchall();//查询所用用户表信息
    void deleteuser(int id);//依据ID删除用户
    void adduser(User user);//添加用户
    void updateuser(User user);
}
