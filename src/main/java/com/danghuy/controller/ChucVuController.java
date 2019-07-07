package com.danghuy.controller;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.pojo.ChucVu;
import com.danghuy.service.ChucVuService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/chucvu")
public class ChucVuController {
    private final ChucVuService chucVuService;


    @Autowired
    public ChucVuController(ChucVuService chucVuService) {
        this.chucVuService = chucVuService;
    }

    @GetMapping
    @Transactional
    public String getPageChucVu(ModelMap modelMap) {
        ChucVu chucVu = chucVuService.getChucVuByID(1);
        System.out.println("tên chức vụ : " + chucVu.getTenChucVu());
        modelMap.addAttribute("tenchucvu", chucVu.getTenChucVu());
        return "chucvu";
    }

    @PostMapping
    @Transactional
    public String addChucVu(@RequestParam String tenChucVu, @RequestParam int idChucVu) {
        chucVuService.addChucVu(idChucVu, tenChucVu);
        return "chucvu";
    }


    public String updatesChucVu(ModelMap modelMap) {
        ChucVu chucVu = chucVuService.updatesChucVuByID(9, "HuyKZ");
        modelMap.addAttribute("tenchucvuUpdate", chucVu.getTenChucVu());
        return "chucvu";
    }


    public String deleteChucVu(){
        chucVuService.deleteChucVu(10);
        return "chucvu";
    }
}
