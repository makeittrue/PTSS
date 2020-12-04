package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;

import cn.itcast.travel.domain.Comment;
import cn.itcast.travel.domain.Course;
import cn.itcast.travel.domain.Message;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.CourseService;
import cn.itcast.travel.service.impl.CourseServiceImpl;

@WebServlet("/course/*")
public class CourseServlet extends BaseServlet {

    private static final long serialVersionUID = 4727966330469254582L;

    private CourseService service = new CourseServiceImpl();

    public void getCourseByType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        List<Course> couseList = service.getCourseByType(type);
        writeValue(couseList, response);
    }

    public void offerCourse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String place = request.getParameter("place");
        String description = request.getParameter("description");
        User user = (User) request.getSession().getAttribute("user");
        int uid = 0;
        if (user != null) {
            uid = user.getUid();
        }
        service.saveOne(title, type, price, place, description, uid);

        writeValue("123", response);
    }

    public void getDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Course course = service.getDetail(id);
        List<Comment> comment = service.getComment(id);
        JSONObject jo = new JSONObject();
        jo.put("course", course);
        jo.put("comment", comment);
        writeValue(jo, response);
    }

    public void comment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String comment = request.getParameter("comment");
        String id = request.getParameter("id");
        service.comment(comment, id);
        List<Comment> commentList = service.getComment(id);
        writeValue(commentList, response);
    }

    public void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = service.getUser();
        User user = (User) request.getSession().getAttribute("user");
        List<Message> messageList = new ArrayList<>();
        if (user != null) {
            messageList = service.getCommentUser(user.getUsername());
        }
        JSONObject jo = new JSONObject();
        jo.put("userList", userList);
        jo.put("messageList", messageList);
        writeValue(jo, response);
    }

    public void getUserInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        User user = service.getUserInfo(username);
        writeValue(user, response);
    }

}
