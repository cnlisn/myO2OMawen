package com.lisn.o2o.web.shop;

import com.lisn.o2o.entity.Area;
import com.lisn.o2o.entity.ShopCategory;
import com.lisn.o2o.service.AreaService;
import com.lisn.o2o.service.ShopCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/shop")
public class ShopManagementController {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/getShopInitInfo", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getShopInitInfo() {
        HashMap<String, Object> modelMap = new HashMap<>();
        ShopCategory shopCategory = new ShopCategory();
        try {
            List<ShopCategory> shopCategories = shopCategoryService.queryShopCategory(shopCategory);
            List<Area> areaList = areaService.getAreaList();
            modelMap.put("success", true);
            modelMap.put("shopCategoryList", shopCategories);
            modelMap.put("areaList", areaList);
        } catch (Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        return modelMap;
    }

    @RequestMapping(value = "/queryShopCategoryById", method = RequestMethod.GET)
    public ShopCategory queryShopCategoryById(Long shopCategoryId) {
        ShopCategory sc = shopCategoryService.queryShopCategoryById(shopCategoryId);
        return sc;
    }
}
