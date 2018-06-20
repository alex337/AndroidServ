package com.hhit.model;

import java.io.Serializable;

public class Course implements Serializable{
    private String coursename;
    private String teacherName;
    public Course(){
        super();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
