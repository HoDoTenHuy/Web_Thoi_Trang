package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrangChuController {

    @RequestMapping("/")
    public String viewTrangChu(ModelMap modelMap) {

        String username = "danghuyvms@gmail.com";
        String password = "danghuy998";
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("password", password);
        return "trangchu";
    }

    @RequestMapping("/login")
    public String pageLogin() {

        return "login";
    }
}
