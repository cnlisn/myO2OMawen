package com.lisn.o2o.Service;

import com.lisn.o2o.BaseTest;
import com.lisn.o2o.entity.ShopCategory;
import com.lisn.o2o.service.ShopCategoryService;
import com.lisn.o2o.service.ShopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShopCategoryServiceTest extends BaseTest {
    @Autowired
    private ShopCategoryService shopCategoryService;


    @Test
    public void queryShopCategory() {
        List<ShopCategory> shopCategories = shopCategoryService.queryShopCategory(new ShopCategory());
        System.out.println("shopCategories.size = " + shopCategories.size());
    }

    @Test
    public void queryShopCategoryById() {
        ShopCategory shopCategory = shopCategoryService.queryShopCategoryById(10L);
        System.out.println("shopCategory.getShopCategoryName = " + shopCategory.getShopCategoryName());
    }

}
