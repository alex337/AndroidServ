package com.hhit.service.serviceimpl;

import com.hhit.dao.WorkDao;
import com.hhit.model.Page;
import com.hhit.model.Work;
import com.hhit.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service(value="workService")
public class WorkServiceImpl implements WorkService{
    @Resource
    WorkDao workDao;

    @Override
    public void addWork(Work work) {
        workDao.addWork(work);

    }

    @Override
    public List<Work> workSearchall(String stuID) {
        return workDao.workSearchall(stuID);
    }

    @Override
    public void deletework(int wID) {
        workDao.deletework(wID);


    }

    @Override
    public List<Work> searchworkList(Page page) {
        return workDao.searchworkList(page);
    }

    @Override
    public Integer searchTotalCount(Page page) {
        return workDao.searchTotalCount(page);
    }

    @Override
    public List<Work> getworkBycondtion(Page page) {
        return workDao.getworkBycondtion(page);
    }

    @Override
    public Work selectBywName(String wName) {
        return workDao.selectBywName(wName);
    }

    @Override
    public void deleteworkbyname(String wName, String stuID,String coursename,String term) {
        workDao.deleteworkbyname(wName,stuID,coursename,term);
    }

    @Override
    public Work selectnameid(String wName, String stuID,String coursename,String term) {
        return workDao.selectnameid(wName,stuID,coursename,term);
    }
}
