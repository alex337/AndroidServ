package com.hhit.service.serviceimpl;

import com.hhit.dao.TeacherDao;
import com.hhit.model.Page;
import com.hhit.model.Teacher;
import com.hhit.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="teaservice")
public class TeacherServiceImpl implements TeacherService {
    @Resource
    TeacherDao teacherDao;

    @Override
    public Teacher selectByteaname(String teacherNmae) {
        return teacherDao.selectByteaname(teacherNmae);
    }

    @Override
    public Teacher selectByteaid(String teacherID) {
        return teacherDao.selectByteaid(teacherID);
    }

    @Override
    public void teaupdatepwd(Teacher teacher) {
       teacherDao.teaupdatepwd(teacher);
    }

    @Override
    public List<Teacher> searchteaList(Page page) {
        return teacherDao.searchteaList(page);
    }

    @Override
    public Integer searchTotalCount(Page page) {
        return teacherDao.searchTotalCount(page);
    }

    @Override
    public List<Teacher> getteaBycondtion(Page page) {
        return teacherDao.getteaBycondtion(page);
    }

    @Override
    public List<Teacher> teaSearchall() {
        return teacherDao.teaSearchall();
    }

    @Override
    public void updatetea(Teacher teacher) {
        teacherDao.updatetea(teacher);
    }

    @Override
    public void deletetea(int teacherID) {
        teacherDao.deletetea(teacherID);
    }

    @Override
    public void addtea(Teacher teacher) {
        teacherDao.addtea(teacher);
    }
}
