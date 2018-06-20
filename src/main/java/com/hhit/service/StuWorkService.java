package com.hhit.service;

import com.hhit.model.Page;
import com.hhit.model.StuWork;
import com.hhit.model.Work;

import java.util.List;

public interface StuWorkService {
    void addStuWork(StuWork stuwork);
    List<StuWork> stuworkSearchall();
    List<Work> searchworkList(Page page);
    Integer searchTotalCount(Page page);
    List<Work> getworkBycondtion(Page page);
    void deleteworkbyname(String wName,String stuID);
    StuWork selectnameid(String wName,String stuID,String coursename,String term);
    void stuupdatesta(StuWork stuWork);
    List<StuWork> selecfinish(String stuID,String status);
    void stuupdateass(StuWork stuWork);
    List<StuWork> stuworksearchsta();
    List<StuWork> stuworkfinish();
    List<StuWork> stuworktea(String teacherName);
    List<StuWork> selectgrade(String stuClass,String coursename,String term);
}
