package com.hhit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Test")
public class Test {
    //ceshi
    @RequestMapping("/test")
    public void test(){
        System.out.println("看看是否成功了你大爷的" +
                "绯闻绯闻");
    }
}
