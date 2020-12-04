package cn.itcast.travel.web.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.Service;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.OfferService;
import cn.itcast.travel.service.impl.OfferServiceImpl;

@WebServlet("/offer/*")
public class OfferServlet extends BaseServlet {
    private OfferService offerService = new OfferServiceImpl();


    public void offer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Map<String, String[]> map = request.getParameterMap();

        User user = (User) request.getSession().getAttribute("user");
        int uid;// 用户id
        if (user == null) {
            // 用户尚未登录
            uid = 0;
        } else {
            // 用户已经登录
            uid = user.getUid();
        }

        // 2.封装对象
        Service service = new Service();
        try {
            BeanUtils.populate(service, map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 3.调用service完成注册
        // UserService service = new UserServiceImpl();
        // ************
        boolean flag = offerService.offer(service);
        ResultInfo info = new ResultInfo();
        // 4.响应结果
        if (flag) {
            // 注册成功
            info.setFlag(true);
        } else {
            // 注册失败
            info.setFlag(false);
            info.setErrorMsg("Fail to Offer service！Please contact the administrator.");
        }

        // 将info对象序列化为json
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(info);

        // 将json数据写回客户端
        // 设置content-type
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(json);
    }

}
