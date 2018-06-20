package com.hhit.service;

import com.hhit.model.Page;
import com.hhit.model.Teacher;
import com.hhit.model.Work;

import java.util.List;

public interface TeacherService {
    Teacher selectByteaname(String teacherName);
    Teacher selectByteaid(String teacherID);
    void teaupdatepwd(Teacher teacher);
    List<Teacher> teaSearchall();
    List<Teacher> searchteaList(Page page);
    Integer searchTotalCount(Page page);
    List<Teacher> getteaBycondtion(Page page);
    void updatetea(Teacher teacher);
    void deletetea(int teacherID);
    void addtea(Teacher teacher);
}
