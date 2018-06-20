package com.hhit.dao;

import com.hhit.model.Assess;

import java.util.List;

public interface AssessDao {

    void addassess(Assess assess);
    Assess selectnameid(String wName,String stuID);
    void updateass(Assess assess);
}
