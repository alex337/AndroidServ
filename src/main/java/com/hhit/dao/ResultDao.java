package com.hhit.dao;

import com.hhit.model.Result;
import com.hhit.model.User;

import java.util.List;

public interface ResultDao {
    void updateabs(Result result);
    Result selectres(String coursename,String stuID,String term);
    void addresult(Result result);
    List<Result> selectresult(String stuClass,String coursename,String term);
    void updatedate(Result result);
    Result selectabs(String stuID,String coursename,String term);
}
