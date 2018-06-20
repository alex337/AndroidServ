package com.hhit.service.serviceimpl;

import com.hhit.dao.StudentDao;
import com.hhit.model.Page;
import com.hhit.model.PageBean;
import com.hhit.model.Student;
import com.hhit.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service(value="stuservice")

public class StudentServiceImpl implements StudentService {

    @Resource
    public StudentDao studentDao;


    @Override
    public List<Student> selectBystuclass(String stuClass) {
        return studentDao.selectBystuclass(stuClass);
    }

    @Override
    public int getCountstuclass(String stuClass) {
        return studentDao.stuclassCount(stuClass);
    }



    @Override
    public int getCountStudent() {
        return studentDao.stuCount();
    }

    //
//    @Override
//    public Student selectBystuclass(String stuClass) {
//        return studentDao.selectBystuclass(stuClass);
//    }

    @Override
    public Student selectBystuname(String stuName) {
        return studentDao.selectBystuname(stuName);
    }



    @Override
    public void stuupdatepass(Student student) {
        studentDao.stuupdatepass(student);

    }

    @Override
    public List<Student> stuSearchall() {
        return studentDao.stuSearchall();
    }

    @Override
    public Student selectBystuid(String stuID) {
        return studentDao.selectBystuid(stuID);
    }

    @Override
    public PageBean<Student> findByPage(int currentPage) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        PageBean<Student> pageBean=new PageBean<Student>();
        pageBean.setCurrPage(currentPage);
        int pageSize=8;
        pageBean.setPageSize(pageSize);
        int totalCount=studentDao.stuCount();
        double tc=totalCount;
        Double num=Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        List<Student> lists=studentDao.findBypage(map);
        pageBean.setLists(lists);
        return pageBean;

    }

    @Override
    public PageBean<Student> findByclass(String stuClass,int currentPage) {
        HashMap<String,Object> map=new HashMap<String,Object>();
        PageBean<Student> pageBean=new PageBean<Student>();
        pageBean.setCurrPage(currentPage);
        int pageSize=8;
        pageBean.setPageSize(pageSize);
        int totalCount=studentDao.stuclassCount(stuClass);
        double tt=totalCount;
        Double num=Math.ceil(tt/pageSize);
        pageBean.setTotalPage(num.intValue());
        map.put("start",(currentPage-1)*pageSize);
        map.put("size",pageBean.getPageSize());
        List<Student> lists=studentDao.findByclass(stuClass,map);
        pageBean.setLists(lists);
        return pageBean;
    }

    @Override
    public List<Student> searchstuList(Page page) {
        return studentDao.searchstuList(page);
    }

    @Override
    public Integer searchTotalCount(Page page) {
        return studentDao.searchTotalCount(page);
    }

    @Override
    public List<Student> getstuBycondtion(Page page) {
        return studentDao.getstuBycondtion(page);
    }

    @Override
    public void updatestu(Student student) {
        studentDao.updatestu(student);
    }

    @Override
    public void deletestu(int stuID) {
        studentDao.deletestu(stuID);
    }

    @Override
    public void addstu(Student student) {
        studentDao.addstu(student);
    }

    @Override
    public void stucall(Student student) {
        studentDao.stucall(student);

    }

    @Override
    public List<Student> searchabsence(String stuClass) {
        return studentDao.searchabsence(stuClass);
    }

    @Override
    public List<Student> absence(String stuClass) {
        return studentDao.absence(stuClass);
    }

    @Override
    public void updatestatus() {
        studentDao.updatestatus();
    }

    @Override
    public List<String> stusearchlist() {
        return studentDao.stusearchlist();
    }

    @Override
    public List<String> selectclass() {
        return studentDao.selectclass();
    }

    @Override
    public List<Student> selectstudent(String stuClass) {
        return studentDao.selectstudent(stuClass);
    }
}
