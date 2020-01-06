package com.lisn.o2o.web.superadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lisn.o2o.dto.ShopExecution;
import com.lisn.o2o.entity.PersonInfo;
import com.lisn.o2o.entity.Shop;
import com.lisn.o2o.enums.ShopStateEnum;
import com.lisn.o2o.service.ShopService;
import com.lisn.o2o.util.HttpServletRequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/superadmin")
public class ShopController {
    @Autowired
    private ShopService shopService;

    @RequestMapping(value = "/registershop", method = RequestMethod.GET)
    public Map<String, Object> registerShop(HttpServletRequest request) {
        HashMap<String, Object> modelMap = new HashMap<>();
        //1、接收并转化相应的参数
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper objectMapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = objectMapper.readValue(shopStr, Shop.class);
        } catch (IOException e) {
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        CommonsMultipartFile shopImg = null;
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (commonsMultipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            shopImg = (CommonsMultipartFile) multipartHttpServletRequest.getFile("shopImg");
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "上传图片不能为空");
            return modelMap;
        }
        //2、注册店铺
        if (shop!=null&& shopImg!=null){
            PersonInfo owner = new PersonInfo();
            // TODO: 2020/1/5
            owner.setUserId(11L);
            shop.setOwnerId(owner.getUserId());
            ShopExecution shopExecution = shopService.addShop(shop, shopImg);
            if (shopExecution.getState()== ShopStateEnum.CHECK.getState()){
                modelMap.put("success", false);
            }else {
                modelMap.put("success", false);
                modelMap.put("errMsg", shopExecution.getStateInfo());
            }
        }else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "请输入店铺信息");
        }
        //3、返回结果
        return modelMap;
    }
}
