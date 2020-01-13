package com.lisn.o2o.service;

import com.lisn.o2o.entity.ShopCategory;

import java.util.List;

public interface ShopCategoryService {

    /**
     * 查询商品类别
     * @param shopCategory
     * @return
     */
    List<ShopCategory> queryShopCategory(ShopCategory shopCategory);

    ShopCategory queryShopCategoryById(Long shopCategoryId);
}
