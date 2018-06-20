package com.hhit.service.serviceimpl;

import com.hhit.dao.CourseDao;
import com.hhit.model.Course;
import com.hhit.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service(value="courseservice")
public class CourseServiceimpl implements CourseService{
    @Resource
    CourseDao courseDao;

    @Override
    public List<String> selectcourse(String teacherName) {
        return courseDao.selectcourse(teacherName);
    }
}


