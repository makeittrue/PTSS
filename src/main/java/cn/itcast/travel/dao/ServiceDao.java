package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Service;

import java.util.List;

public interface ServiceDao {

    public void save(Service service);

    public Service findBySid(int uid);

    List<Service> findByUid(int uid);
}
