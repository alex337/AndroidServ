package com.hhit.dao;

import com.hhit.model.Page;
import com.hhit.model.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    Student selectBystuname(String stuName);
    Student selectBystuid(String stuID);
//    Student selectBystuclass(String stuClass);
    void stuupdatepass(Student student);
    List<Student> stuSearchall();
    List<Student> selectBystuclass(String stuClass);
    int stuCount();
    int stuclassCount(String stuClass);
    List<Student> findBypage(HashMap<String,Object> map);
    List<Student> findByclass(String stuClass,HashMap<String,Object> map);
    List<Student> getstuBycondtion(Page page);
    List<Student>  searchstuList(Page page);
    Integer searchTotalCount(Page page);
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
