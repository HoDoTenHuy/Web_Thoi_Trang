package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TrangChuController {
    @GetMapping
    public String pageDefault(){
        return "trangchu";
    }


}
