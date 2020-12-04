package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.ServiceDao;
import cn.itcast.travel.dao.impl.ServiceDaoImpl;
import cn.itcast.travel.domain.Service;
import cn.itcast.travel.service.OfferService;

public class OfferServiceImpl implements OfferService {

    ServiceDao sd = new ServiceDaoImpl();

    @Override
    public boolean offer(Service _service)
    {
        sd.save(_service);
        return true;
    }
}
