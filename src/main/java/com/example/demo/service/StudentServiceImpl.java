package com.example.demo.service;

import com.example.demo.dao.BaseRepository;
import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    BaseRepository baseRepository;

    @Override
    public int addCourse(int studentId, Course course) {
        if(course.getMaxStudent() - course.getEnrollment() > 0){
            baseRepository.studentAddCourse(studentId,course);
            baseRepository.incEnrollment(course.getId());
            return 1;//adding success
        }
        else {
            return 2;//2 represent the course enrollment is already full
        }
    }

    @Override
    public boolean checkStudentHasCourse(int studentId, int courseId) {
        List<Integer> courses = baseRepository.checkCoursesStudentHas(studentId);
        for(int i=0; i < courses.size();i++){
            if(courses.get(i)==courseId){
                return true;
            }
        }
        return false;
    }

    @Override
    public int deleteCourse(int studentId, Course course) {
        if(checkStudentHasCourse(studentId, course.getId())) {
            baseRepository.studentDeleteCourse(studentId, course);
            baseRepository.decEnrollment(course.getId());
            return 1;//delete success
        }
        else {
            return 2;//fail
        }
    }

    @Override
    public List<Course> findAllCourse() {
        return baseRepository.findAllCourse();
    }

}
