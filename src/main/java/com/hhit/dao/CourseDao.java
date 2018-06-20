package com.hhit.dao;

import com.hhit.model.Course;

import java.util.List;

public interface CourseDao {
   List<String> selectcourse(String teacherName);
}
