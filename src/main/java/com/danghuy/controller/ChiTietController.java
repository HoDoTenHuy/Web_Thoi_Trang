package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class ChiTietController {
    @GetMapping
    public String pageDefault(){
        return "login";
    }

    @PostMapping
    public String showInforUser(@ModelAttribute NhanVienEntity nhanVien, ModelMap modelMap){
        modelMap.addAttribute("nv", nhanVien);
        return "login";
    }
}
