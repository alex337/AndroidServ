package com.hhit.service;

import com.hhit.model.Page;
import com.hhit.model.PageBean;
import com.hhit.model.Student;

import java.util.List;

public interface StudentService {
    Student selectBystuname(String stuName);
    Student selectBystuid(String stuID);
//    Student selectBystuclass(String stuClass);
    void stuupdatepass(Student student);
    List<Student> stuSearchall();
    List<Student> selectBystuclass(String stuClass);
    int getCountStudent();
    int getCountstuclass(String stuClass);
    PageBean<Student> findByPage(int currentPage);
    PageBean<Student> findByclass(String stuClass,int currentPage);
    List<Student> searchstuList(Page page);
    Integer searchTotalCount(Page page);
    List<Student> getstuBycondtion(Page page);
    void updatestu(Student student);
    void deletestu(int stuID);
    void addstu(Student student);
    void stucall(Student student);
    List<Student> searchabsence(String stuClass);
    List<Student> absence(String stuClass);
    void updatestatus();
    List<String> stusearchlist();
    List<String> selectclass();
    List<Student> selectstudent(String stuClass);


}
