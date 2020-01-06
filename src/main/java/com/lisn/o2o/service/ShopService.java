package com.lisn.o2o.service;

import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopService {

    /**
     * 新增店铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
}
