package com.hhit.service;

import com.hhit.model.Page;
import com.hhit.model.Work;

import java.util.List;

public interface WorkService {
    void addWork(Work work);
    List<Work> workSearchall(String stuID);
    Work selectBywName(String wName);

    void deletework(int wID);
    List<Work> searchworkList(Page page);
    Integer searchTotalCount(Page page);
    List<Work> getworkBycondtion(Page page);
    void deleteworkbyname(String wName,String stuID,String coursename,String term);
    Work selectnameid(String wName,String stuID,String coursename,String term);
}
