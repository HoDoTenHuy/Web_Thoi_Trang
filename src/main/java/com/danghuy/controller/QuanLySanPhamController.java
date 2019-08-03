package com.danghuy.controller;

import com.danghuy.entity.ChiTietSanPhamEntity;
import com.danghuy.service.ChiTietSanPhamService;
import com.danghuy.service.impl.ChiTietHoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quanlysanpham")
public class QuanLySanPhamController {
    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping(produces = "text/html; charset=UTF8")
    public String pageDefault(ModelMap modelMap) {
        List<ChiTietSanPhamEntity> chiTietSanPhamEntities = chiTietSanPhamService.getAllChiTietSanPham();
        modelMap.addAttribute("listChiTiet", chiTietSanPhamEntities);
        return "quanlysanpham";
    }
}
