package com.danghuy.controller;

import com.danghuy.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chucvu")
public class ChucVuController {
    private final ChucVuService chucVuService;

    @Autowired
    public ChucVuController(ChucVuService chucVuService){
        this.chucVuService = chucVuService;
    }

    @GetMapping
    @Transactional
    public String getPageChucVu(ModelMap modelMap){
        modelMap.addAttribute("tenchucvu", chucVuService.getChucVuByID(1));
        return "chucvu";
    }
}
