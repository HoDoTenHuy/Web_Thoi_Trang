package com.danghuy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class DashBorardController {
    @GetMapping
    public String pageDefault(){

        return "dashboard";
    }
}
