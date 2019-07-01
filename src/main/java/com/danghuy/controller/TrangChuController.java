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

    @PostMapping
    public String updatesInforUser(){

        return "chitiet";
    }

}
