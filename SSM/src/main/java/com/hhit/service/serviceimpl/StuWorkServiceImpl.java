package com.hhit.service.serviceimpl;

import com.hhit.dao.StuWorkDao;
import com.hhit.dao.WorkDao;
import com.hhit.model.Page;
import com.hhit.model.StuWork;
import com.hhit.model.Work;
import com.hhit.service.StuWorkService;
import com.hhit.service.WorkService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="stuworkService")
public class StuWorkServiceImpl implements StuWorkService {
    @Resource
    StuWorkDao stuworkDao;

    @Override
    public void addStuWork(StuWork stuwork) {
        stuworkDao.addStuWork(stuwork);
    }

    @Override
    public List<StuWork> stuworkSearchall() {
        return stuworkDao.stuworkSearchall();
    }

    @Override
    public List<Work> searchworkList(Page page) {
        return null;
    }

    @Override
    public Integer searchTotalCount(Page page) {
        return stuworkDao.searchTotalCount(page);
    }

    @Override
    public List<Work> getworkBycondtion(Page page) {
        return null;
    }

    @Override
    public void deleteworkbyname(String wName, String stuID) {
        stuworkDao.deleteworkbyname(wName,stuID);
    }

    @Override
    public StuWork selectnameid(String wName, String stuID,String coursename,String term) {
        return stuworkDao.selectnameid(wName,stuID,coursename,term);
    }

    @Override
    public void stuupdatesta(StuWork stuWork) {
        stuworkDao.stuupdatesta(stuWork);
    }

    @Override
    public List<StuWork> selecfinish(String stuID, String status) {
        return stuworkDao.selecfinish(stuID,status);
    }

    @Override
    public void stuupdateass(StuWork stuWork) {
        stuworkDao.stuupdateass(stuWork);
    }

    @Override
    public List<StuWork> stuworksearchsta() {
        return stuworkDao.stuworksearchsta();
    }

    @Override
    public List<StuWork> stuworkfinish() {
        return stuworkDao.stuworkfinish();
    }

    @Override
    public List<StuWork> stuworktea(String teacherName) {
        return stuworkDao.stuworktea(teacherName);
    }

    @Override
    public List<StuWork> selectgrade(String stuClass, String coursename, String term) {
        return stuworkDao.selectgrade(stuClass,coursename,term);
    }
}
