package com.danghuy.controller;

import com.danghuy.entity.GopYEntity;
import com.danghuy.service.impl.GopYServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/gopy")
public class GopYController {
    @Autowired
    GopYServiceImpl gopYService;

    @GetMapping(produces = "text/html; charset=UTF8")
    public String pageDefault(ModelMap modelMap){
        List<GopYEntity> gopYEntities = gopYService.getAllGopY();
        modelMap.addAttribute("listgopy", gopYEntities);
        return "gopy";
    }
}
