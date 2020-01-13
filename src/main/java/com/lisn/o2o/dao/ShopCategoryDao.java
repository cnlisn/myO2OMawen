package com.lisn.o2o.dao;

import com.lisn.o2o.entity.ShopCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopCategoryDao {
    /**
     * 查询商品类别
     *
     * @param shopCategoryCondition
     * @return
     */
    List<ShopCategory> queryShopCategory(
            @Param("shopCategoryCondition") ShopCategory shopCategoryCondition);

    /**
     * @param shopCategoryId
     * @return
     */
    ShopCategory queryShopCategoryById(long shopCategoryId);
}
