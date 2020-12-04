package cn.itcast.travel.service.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.itcast.travel.domain.Comment;
import cn.itcast.travel.domain.Course;
import cn.itcast.travel.domain.Message;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CourseService;
import cn.itcast.travel.util.JDBCUtils;

public class CourseServiceImpl implements CourseService {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Course> getCourseByType(String type) {
        String sql = "select * from tab_course where type = '" + type + "' order by price asc";
        return template.query(sql, new BeanPropertyRowMapper<Course>(Course.class));
    }

    @Override
    public void saveOne(String title, String type, String price, String place, String description, int uid) {
        String picture = "";
        if ("Math".equals(type)) {
            picture = "images/math.jpg";
        } else if ("Science".equals(type)) {
            picture = "images/science.jpg";
        } else if ("Foreign Language".equals(type)) {
            picture = "images/language.jpg";
        } else if ("Business".equals(type)) {
            picture = "images/business.jpg";
        } else if ("Computer".equals(type)) {
            picture = "images/computer.jpg";
        }
        String sql = "insert into tab_course(title, type, price, place, description, uid, picture) values (?,?,?,?,?,?,?)";
        template.update(sql, title, type, price, place, description, uid, picture);
    }

    @Override
    public Course getDetail(String id) {
        String sql = "select * from tab_course where id = " + id;
        return template.queryForObject(sql, new BeanPropertyRowMapper<Course>(Course.class));
    }

    @Override
    public List<Comment> getComment(String id) {
        String sql = "select * from tab_comment where course_id = " + id;
        return template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class));
    }

    @Override
    public void comment(String comment, String id) {
        String sql = "insert into tab_comment(course_id, comment) values(?,?)";
        template.update(sql, id, comment);
    }

    @Override
    public List<User> getUser() {
        String sql = "select * from tab_user";
        return template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public List<Message> getCommentUser(String username) {
        String sql = "select * from tab_message where username = '" + username + "'";
        return template.query(sql, new BeanPropertyRowMapper<Message>(Message.class));
    }

    @Override
    public User getUserInfo(String username) {
        String sql = "select * from tab_user where username = '" + username + "'";
        return template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class));
    }

}
