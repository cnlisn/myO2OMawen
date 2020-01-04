package com.lisn.o2o.web.superadmin;

import com.lisn.o2o.entity.Area;
import com.lisn.o2o.entity.ConstantForSuperAdmin;
import com.lisn.o2o.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/superdmin")
public class AreaController {
    Logger logger = LoggerFactory.getLogger(AreaController.class);
    @Autowired
    AreaService areaService;

    @RequestMapping(value = "/listareas", method = RequestMethod.GET)
    //将返回数据转换为json
    @ResponseBody
    private Map<String, Object> listArea() {
        logger.info("====start====");
        long startTime = System.currentTimeMillis();
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            List<Area> list = areaService.getAreaList();
            map.put("success", true);
            map.put(ConstantForSuperAdmin.PAGE_SIZE, list);
            map.put(ConstantForSuperAdmin.TOTAL, list.size());
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.toString());
        }
        long endTime = System.currentTimeMillis();
        logger.debug("====costTime:[{}ms]", endTime - startTime);
        logger.info("====end====");
        logger.error("test error!");
        return map;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    private String hello() {
        return "Hell world";
    }

}
