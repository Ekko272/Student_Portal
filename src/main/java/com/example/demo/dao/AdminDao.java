package com.example.demo.dao;

import com.example.demo.model.Course;

public interface AdminDao {
    int addCourse(Course c);
    Course serachCourse(Integer id);
    int deleteCourse(Integer id);

}
