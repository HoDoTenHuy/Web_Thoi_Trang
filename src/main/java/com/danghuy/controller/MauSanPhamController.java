package com.danghuy.controller;

import com.danghuy.entity.MauSanPhamEntity;
import com.danghuy.service.impl.MauSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/themmau")
public class MauSanPhamController {
    @Autowired
    MauSanPhamServiceImpl mauSanPhamService;

    @GetMapping
    public String pageDefault(ModelMap modelMap) {
        List<MauSanPhamEntity> mauSanPhamEntities = mauSanPhamService.layDanhSachMau();
        modelMap.addAttribute("listMau", mauSanPhamEntities);
        return "mausanpham";
    }
}
