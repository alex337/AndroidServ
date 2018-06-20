package com.hhit.service.serviceimpl;

import com.hhit.dao.AssessDao;
import com.hhit.model.Assess;
import com.hhit.service.AssessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value="assessservice")
public class AssessServiceimpl implements AssessService{
    @Resource
    AssessDao assessDao;


    @Override
    public void addassess(Assess assess) {
        assessDao.addassess(assess);
    }

    @Override
    public Assess selectnameid(String wName, String stuID) {
        return assessDao.selectnameid(wName,stuID);
    }

    @Override
    public void updateass(Assess assess) {
        assessDao.updateass(assess);
    }
}


