package com.hhit.model;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable{
    private String stuName;
    private String stuID;
    private String stuClass;
    private String stuPwd;
    private String stuSta;
    private int stuAbsence;
    private String stuStatus;
    private Date date;

    public Student(){
        super();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuID() {
        return stuID;
    }

    public void setStuID(String stuID) {
        this.stuID = stuID;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuPwd() {
        return stuPwd;
    }

    public void setStuPwd(String stuPwd) {
        this.stuPwd = stuPwd;
    }

    public int getStuAbsence() {
        return stuAbsence;
    }

    public void setStuAbsence(int stuAbsence) {
        this.stuAbsence = stuAbsence;
    }

    public String getStuStatus() {
        return stuStatus;
    }

    public void setStuStatus(String stuStatus) {
        this.stuStatus = stuStatus;
    }

    public String getStuSta() {
        return stuSta;
    }

    public void setStuSta(String stuSta) {
        this.stuSta = stuSta;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}