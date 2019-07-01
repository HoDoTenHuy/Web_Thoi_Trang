package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class TrangChuController {
    @GetMapping
    public String pageDefault(){
        return "trangchu";
    }

    @GetMapping("/{name}")
    public String nhanThamSo(@PathVariable String name, ModelMap modelMap){
        modelMap.addAttribute("hoten", name);
        return "trangchu";
    }

}
