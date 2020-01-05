package com.lisn.o2o.service.impl;

import com.lisn.o2o.dao.ShopDao;
import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.Shop;
import com.lisn.o2o.enums.ShopStateEnum;
import com.lisn.o2o.service.ShopService;
import com.lisn.o2o.util.FileUtil;
import com.lisn.o2o.util.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.util.Date;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        return null;
    }

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        try {
            shop.setEnableStatus(ShopStateEnum.CHECK.getState());
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());
            //添加店铺信息
            int effectedNum = shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            } else {
                if (shopImg != null) {
                    //存储图片
                    try {
                        addShopImg(shop, shopImg);
                    } catch (Exception e) {
                        throw new RuntimeException("addShopImg error:" + e.getMessage());
                    }
                    //更新店铺的图片地址
                    effectedNum = shopDao.updateShop(shop);
                    if (effectedNum <= 0) {
                        throw new RuntimeException("更新店铺的图片地址失败");
                    }
                }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException("addShop errpr：" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) {
        //获取shop图片目录的相对值路径
        String dest = FileUtil.getShopImagePath(shop.getShopId());
        String shopImagAddr = ImageUtil.generateThumbnail(shopImg, dest);
        shop.setShopImg(shopImagAddr);
    }

    @Override
    public ShopExecution updateShop(Shop shop) {
        return null;
    }
}
