package com.lisn.o2o.dao;

import com.lisn.o2o.BaseTest;
import com.lisn.o2o.entity.Area;
import com.lisn.o2o.entity.PersonInfo;
import com.lisn.o2o.entity.Shop;
import com.lisn.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    ShopDao shopDao;

    @Test
    public void insertShop(){
        Area area = new Area();
        area.setAreaId(5L);
        PersonInfo owner = new PersonInfo();
        owner.setUserId(11L);
        ShopCategory shopCategory = new ShopCategory();
        Shop shop = new Shop();
        shop.setArea(area);
        shop.setOwnerId(owner.getUserId());
        shop.setShopCategory(shopCategory);
        shop.setShopName("测试的店铺");
        shop.setShopDesc("test");
        shop.setShopAddr("test");
        shop.setPhone("test");
        shop.setShopImg("test");
        shop.setCreateTime(new Date());
        shop.setEnableStatus(1);
        shop.setAdvice("审核中");

        int i = shopDao.insertShop(shop);
        assertEquals(1, i);
    }

    @Test
    public void testUpdateShop(){
        Shop shop = new Shop();
        shop.setShopId(29L);
        shop.setShopDesc("测试描述");
        shop.setShopAddr("测试地址");
        shop.setLastEditTime(new Date());
        int i = shopDao.updateShop(shop);
        assertEquals(1,i);
    }
}






































