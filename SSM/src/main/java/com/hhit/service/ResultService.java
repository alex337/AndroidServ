package com.hhit.service;

import com.hhit.model.Result;


import java.util.List;

public interface ResultService {
    void updateabs(Result result);
    Result selectres(String coursename,String stuID,String term);
    void addresult(Result result);
    List<Result> selectresult(String stuClass,String coursename,String term);
    void updatedate(Result result);
    Result selectabs(String stuID,String coursename,String term);
}
