package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.ServiceDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Service;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServiceDaoImpl implements ServiceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Service> findByUid(int uid) {
        String sql = "select * from tab_service where uid = ?";
        return template.query(sql, new BeanPropertyRowMapper<Service>(Service.class), uid);
    }

    @Override
    public Service findBySid(int uid) {
        String sql = "select * from tab_service where sid = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Service>(Service.class), uid);
    }

    @Override
    public void save(Service service){
        String sql = "insert into tab_service(uid, cid, price, place, stitle, sbody)" +
                "values(?,?,?,?,?,?)";
        template.update(sql, service.getUid(),
                service.getCid(), service.getPrice(), service.getPlace(), service.getStitle(),
                service.getSbody());
    }
}
