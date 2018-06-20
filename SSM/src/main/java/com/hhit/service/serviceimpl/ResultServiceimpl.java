package com.hhit.service.serviceimpl;

import com.hhit.dao.ResultDao;
import com.hhit.model.Result;
import com.hhit.service.ResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="resultservice")
public class ResultServiceimpl implements ResultService{
    @Resource
    ResultDao resultDao;

    @Override
    public void updateabs(Result result) {
        resultDao.updateabs(result);
    }

    @Override
    public Result selectres(String coursename, String stuID, String term) {
        return resultDao.selectres(coursename,stuID,term);
    }

    @Override
    public void addresult(Result result) {
        resultDao.addresult(result);
    }

    @Override
    public List<Result> selectresult(String stuClass, String coursename, String term) {
        return resultDao.selectresult(stuClass,coursename,term);
    }

    @Override
    public void updatedate(Result result) {
        resultDao.updatedate(result);
    }

    @Override
    public Result selectabs(String stuID, String coursename, String term) {
        return resultDao.selectabs(stuID,coursename,term);
    }
}


