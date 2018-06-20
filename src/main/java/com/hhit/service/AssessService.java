package com.hhit.service;

import com.hhit.model.Assess;


import java.util.List;

public interface AssessService {


    void addassess(Assess assess);
    Assess selectnameid(String wName,String stuID);
    void updateass(Assess assess);


}
