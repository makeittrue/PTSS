package cn.itcast.travel.service;

import java.util.List;

import cn.itcast.travel.domain.Comment;
import cn.itcast.travel.domain.Course;
import cn.itcast.travel.domain.Message;
import cn.itcast.travel.domain.User;

public interface CourseService {
    public List<Course> getCourseByType(String type);

    public void saveOne(String title, String type, String price, String place, String description, int uid);

    public Course getDetail(String id);

    public List<Comment> getComment(String id);

    public void comment(String comment, String id);

    public List<User> getUser();

    public List<Message> getCommentUser(String username);

    public User getUserInfo(String username);
}
