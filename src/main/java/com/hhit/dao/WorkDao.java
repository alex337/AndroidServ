package com.hhit.dao;

import com.hhit.model.Page;
import com.hhit.model.Work;

import java.util.List;

public interface WorkDao {
    void addWork(Work work);//文件上传与数据库配合值传递
    List<Work> workSearchall(String stuID);
    void deletework(int wID);
    List<Work> getworkBycondtion(Page page);
    List<Work>  searchworkList(Page page);
    Integer searchTotalCount(Page page);
    Work selectBywName(String wName);
    void deleteworkbyname(String wName,String stuID,String coursename,String term);
    Work selectnameid(String wName,String stuID,String coursename,String term);

}
