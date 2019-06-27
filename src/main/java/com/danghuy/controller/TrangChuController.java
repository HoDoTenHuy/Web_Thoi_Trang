package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TrangChuController {

    @RequestMapping("/")
    public ModelAndView viewTrangChu() {
        ModelAndView viewTrangChu = new ModelAndView();
        viewTrangChu.setViewName("trangchu");
        String username = "danghuyvms@gmail.com";
        String password = "danghuy998";
        viewTrangChu.addObject("tenDangNhap", username);
        viewTrangChu.addObject("matKhau", password);
        return viewTrangChu;
    }

    @RequestMapping("/login")
    public String pageLogin() {

        return "login";
    }
}
