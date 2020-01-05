package com.lisn.o2o.service;

import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.Shop;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public interface ShopService {
    ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize);

    /**
     * 新增店铺
     * @param shop
     * @param shopImg
     * @return
     */
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);

    /**
     * 更新店铺信息
     * @param shop
     * @return
     */
    ShopExecution updateShop(Shop shop);
}
