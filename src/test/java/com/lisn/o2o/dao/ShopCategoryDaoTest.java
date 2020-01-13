package com.lisn.o2o.dao;

import com.lisn.o2o.BaseTest;
import com.lisn.o2o.entity.ShopCategory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShopCategoryDaoTest extends BaseTest {
    @Autowired
    ShopCategoryDao shopCategoryDao;

    @Test
    public void TestQueryShopCategory() {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(new ShopCategory());
        System.out.println("shopCategories.size=" + shopCategories.size());
        assertEquals(18, shopCategories.size());
    }

    @Test
    public void TestQueryShopCategoryById() {
        ShopCategory sc = new ShopCategory();
        sc.setParentId(10L);
        ShopCategory shopCategory = shopCategoryDao.queryShopCategoryById(sc.getParentId());
        System.out.println("shopCategory.getShopCategoryName() = " + shopCategory.getShopCategoryName());
//        assertEquals(1, 5);
    }
}






































