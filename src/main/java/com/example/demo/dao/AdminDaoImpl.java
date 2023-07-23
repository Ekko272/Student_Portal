package com.example.demo.dao;

import com.example.demo.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AdminDaoImpl implements AdminDao{
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int addCourse(Course c) {
        String sql ="INSERT INTO course (c_id, maxStudent, enrollment, location, sTime, showEnable, description, eTime, time, name, price, mode, c_time, c_day, instructor, nc)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);\n";

        return jdbcTemplate.update(sql, c.getC_id(), c.getMaxStudent(), c.getEnrollment(), c.getLocation(), c.getsTime(), c.getShowEnable(),
                c.getDescription(), c.geteTime(), c.geteTime(), c.getName(), c.getPrice(),
                c.getMode(), c.getC_time(), c.getC_day(), c.getInstructor(), c.getNc());
    }

    @Override
    public Course serachCourse(Integer id) {
        String sql = "select * from course where c_id=?;";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), id);
        } catch (EmptyResultDataAccessException e){
            String msg = "There is no course "+id;
            System.out.println(msg);
            return null;
        }
    }

    @Override
    public int deleteCourse(Integer id) {
        String sql ="DELETE FROM course WHERE c_id=?;";
        return jdbcTemplate.update(sql, id);
    }


}