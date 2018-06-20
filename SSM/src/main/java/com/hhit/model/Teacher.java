package com.hhit.model;

public class Teacher {
    private String teacherID;
    private String teacherName;
    private String teacherPwd;
    private String teacherTitle;
    private String teacherDep;
    private String teacherCou;

    public Teacher() {
       super();
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherPwd() {
        return teacherPwd;
    }

    public void setTeacherPwd(String teacherPwd) {
        this.teacherPwd = teacherPwd;
    }

    public String getTeacherTitle() {
        return teacherTitle;
    }

    public void setTeacherTitle(String teacherTitle) {
        this.teacherTitle = teacherTitle;
    }

    public String getTeacherDep() {
        return teacherDep;
    }

    public void setTeacherDep(String teacherDep) {
        this.teacherDep = teacherDep;
    }

    public String getTeacherCou() {
        return teacherCou;
    }

    public void setTeacherCou(String teacherCou) {
        this.teacherCou = teacherCou;
    }
}
