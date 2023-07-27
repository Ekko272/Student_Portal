package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    BaseRepository baseRepository;

    @Override
    public int addCourse(int studentId, Course course) {
        if(course.getMaxStudent() - course.getEnrollment() > 0){
            baseRepository.studentAddCourse(studentId,course);
            return 1;//adding success
        }
//        if()
        else {
            return 2;//2 represent the course enrollment is already full
        }



    }

}
