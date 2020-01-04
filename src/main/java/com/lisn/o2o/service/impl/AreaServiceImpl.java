package com.lisn.o2o.service.impl;

import com.lisn.o2o.dao.AreaDao;
import com.lisn.o2o.entity.Area;
import com.lisn.o2o.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    AreaDao areaDao;

    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }
}
