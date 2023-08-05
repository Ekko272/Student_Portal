package com.example.demo.dao;

import com.example.demo.model.Course;
import com.example.demo.model.Order;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Repository
public class BaseRepositoryImpl implements BaseRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public int addCourse(Course c) {
        String sql ="INSERT INTO course (id, maxStudent, enrollment, location, start_date, showEnable, description, end_date, name, price, mode, instructor, week_days, time_interval, num_of_weeks)\n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);\n";

        return jdbcTemplate.update(sql, c.getId(), c.getMaxStudent(), c.getEnrollment(), c.getLocation(), c.getStartDate(), c.getShowEnable(),
                c.getDescription(), c.getEndDate(), c.getName(), c.getPrice(),
                c.getMode(), c.getInstructor(), c.getWeekDays(), c.getTimeInterval(), c.getNumOfWeeks());
    }

    @Override
    public Course serachCourse(Integer id) {
        String sql = "select * from course where id=?;";
        try {
            Course course = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Course.class), id);
            return course;
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public int deleteCourse(Integer id) {
        String sql ="DELETE FROM course WHERE id=?;";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public int searchUser(String username) {
        String sql="select * from users where username=?;";
        try {
            if (jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username) != null) {
                return 1;
            }
        }catch (Exception e){
            return 2;
        }
        return 3;

    }

    @Override
    public int addUser(User user) {
        String sql = "insert into users(username, password, user_id) values(?,?,?);";
        return jdbcTemplate.update(sql,user.getUserName(),user.getPassword(),user.getId());
    }

    @Override
    public User checkLoginIn(String username, String password) {
        String sql="select * from users where username=?;";
        int i = searchUser(username);
        if (i==1){
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
            if(Objects.equals(user.getPassword(), password)){
                return user;
            }
            else{
                return null;
            }
        }
        else{
            return null;
        }

    }

    @Override
    public User searchUserAndReturn(String username) {
        String sql="select * from users where username=?;";
        int i = searchUser(username);
        if (i==1) {
            User user = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username);
            return user;
        }else{
                return null;
            }

    }

    @Override
    public int studentAddCourse(int studentId,Course c) {
        String sql = "INSERT INTO `helloWeb`.`student_course` (`student_id`, `course_id`) VALUES (?, ?);";
        try {
            jdbcTemplate.update(sql, studentId, c.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int studentDeleteCourse(int studentId, Course c) {
        String sql = "delete from student_course where student_id=? and course_id=?;";
        try{
            jdbcTemplate.update(sql, studentId, c.getId());
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Integer> checkCoursesStudentHas(int id) {
        String sql = "SELECT course.id\n" +
                "FROM course\n" +
                "JOIN student_course ON course.id = student_course.course_id\n" +
                "WHERE student_course.student_id=?;";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql, id);
        List<Integer> coursesHave = new ArrayList<>();
        for(int i=0; i < maps.size();i++){
            Integer o = (Integer)maps.get(i).get("id");
            coursesHave.add(o);
        }
        return coursesHave;

    }

    @Override
    public void incEnrollment(Integer id) {
        String sql="UPDATE course SET enrollment = enrollment + 1 WHERE id=?;";
        try {
            jdbcTemplate.update(sql, id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void decEnrollment(Integer id) {
        String sql="UPDATE course SET enrollment = enrollment - 1 WHERE id=?;";
        try {
            jdbcTemplate.update(sql, id);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Course> findAllCourse() {
        String sql="select * from course;";
        List<Course> courseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class));
        return courseList;
    }

    @Override
    public List<Course> findAllCourseStudentHas(int id) {
        List<Course> courseList = null;
        try {
            String sql = "SELECT * FROM course JOIN student_course ON course.id = student_course.course_id WHERE student_course.student_id=?;";
            courseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }
    //SELECT * FROM course JOIN student_course ON course.id = student_course.course_id WHERE student_course.student_id=5 AND approved=0;

    @Override
    public List<Course> findAllNotApprovedCourseStudentHas(int id) {
        List<Course> courseList = null;
        try {
            String sql = "SELECT * FROM course JOIN student_course ON course.id = student_course.course_id WHERE student_course.student_id=? AND approved=0;";
            courseList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Course.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return courseList;
    }

    @Override
    public int saveOrderPayment(int studentId, Order order) {
        String sql = "INSERT INTO orders (id, fee, enterDate, courseId, paymentDate, approved, note, studentId) VALUES (?,?,?,?,?,?,?,?);";
        try {
            jdbcTemplate.update(sql, order.getId(), order.getFee(), order.getEnterDate(),
                    order.getCourseId(), order.getPaymentDate(), order.isApproved(), order.getNote(), studentId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return 0;
    }



    @Override
    public int approvePayment(Order order) {
        String sql = "update orders set approved=1 where id=?;";
        try {
            int i = jdbcTemplate.update(sql, order.getId());
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Order> findAllOrderByStudentId(int studentId) {
        String sql = "select * from orders where studentId=?;";
        try {
            List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
            return orders;
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> findAllOrderNotApproved() {
        String sql = "select * from orders where approved=0;";
        try{
            List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
            return orders;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Order> findAllOrder() {
        String sql = "select * from orders;";
        try {
            List<Order> orders = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Order.class));
            return orders;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public Order findOrderById(int orderId) {
        String sql = "select * from orders where id=?;";
        try {
            Order order = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Order.class));
            return order;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int setCourseApprovedOrNot(int studentId, int courseId, int choice) {
        String sql = "update student_course set approved=? where student_id=? and course_id=?;";
        try {
            int i = jdbcTemplate.update(sql,choice,studentId,courseId);
            return i;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }


}
