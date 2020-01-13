package com.lisn.o2o.service.impl;

import com.lisn.o2o.dao.ShopCategoryDao;
import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.ShopCategory;
import com.lisn.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;


    @Override
    public List<ShopCategory> queryShopCategory(ShopCategory shopCategory) {
        List<ShopCategory> shopCategories = shopCategoryDao.queryShopCategory(shopCategory);

        return shopCategories;
    }

    @Override
    public ShopCategory queryShopCategoryById(Long shopCategoryId) {
        ShopCategory shopCategory = shopCategoryDao.queryShopCategoryById(shopCategoryId);
        return shopCategory;
    }
}
