package com.hhit.dao;

import com.hhit.model.Page;
import com.hhit.model.Teacher;

import java.util.List;

public interface TeacherDao {
    Teacher selectByteaname(String teaacherName);
    void teaupdatepwd(Teacher teacher);
    Teacher selectByteaid(String teacherID);
    List<Teacher> teaSearchall();
    List<Teacher> searchteaList(Page page);
    Integer searchTotalCount(Page page);
    List<Teacher> getteaBycondtion(Page page);
    void updatetea(Teacher teacher);
    void deletetea(int teacherID);
    void addtea(Teacher teacher);
}
