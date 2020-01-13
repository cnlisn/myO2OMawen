package com.lisn.o2o.web.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/shop", method = { RequestMethod.GET,
        RequestMethod.POST })
public class AdminController {


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    private String register() {
        return "shop/register";
    }


    @RequestMapping(value = "/shopedit", method = RequestMethod.GET)
    private String shopEdit() {
        return "shop/shopedit";
    }

}
