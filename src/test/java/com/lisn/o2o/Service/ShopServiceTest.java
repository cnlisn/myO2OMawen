package com.lisn.o2o.Service;

import com.lisn.o2o.BaseTest;
import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.Area;
import com.lisn.o2o.entity.PersonInfo;
import com.lisn.o2o.entity.Shop;
import com.lisn.o2o.entity.ShopCategory;
import com.lisn.o2o.enums.ShopStateEnum;
import com.lisn.o2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;


    @Test
    public void addShop() {
        Area area = new Area();
        area.setAreaId(5L);
        PersonInfo owner = new PersonInfo();
        owner.setUserId(11L);
        ShopCategory shopCategory = new ShopCategory();
        Shop shop = new Shop();
        shop.setArea(area);
        shop.setOwnerId(owner.getUserId());
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺1");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(ShopStateEnum.CHECK.getState());
        shop.setAdvice("审核中");

//        File shopImg = new File("/Users/lishan/IdeaProjects/FileDatabase/11.jpg");
//        ShopExecution se = shopService.addShop(shop, shopImg);
//        assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
    }

}
