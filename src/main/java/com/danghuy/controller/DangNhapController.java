package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {

    @GetMapping
    public String pageDefault() {

        return "dangnhap";
    }

    @PostMapping
    public String xuLyDangNhap(@RequestParam String username, @RequestParam String password) {
        if (username.equals("danghuy998") && password.equals("123456")) {
            return "redirect:/";
        } else
            return "dangnhap";
    }
}
