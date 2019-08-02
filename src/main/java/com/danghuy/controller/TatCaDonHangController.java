package com.danghuy.controller;

import com.danghuy.entity.ChiTietHoaDonEntity;
import com.danghuy.entity.HoaDonEntity;
import com.danghuy.service.impl.ChiTietHoaDonServiceImpl;
import com.danghuy.service.impl.HoaDonServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tatcadonhang")
public class TatCaDonHangController {
    @Autowired
    HoaDonServiceImpl hoaDonService;
    @Autowired
    ChiTietHoaDonServiceImpl chiTietHoaDonService;
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @GetMapping(produces = "text/html; charset=UTF8")
    public String pageDefault(ModelMap modelMap){
        List<HoaDonEntity> hoaDonEntities = hoaDonService.layAllHoaDon();
        modelMap.addAttribute("listHoaDon", hoaDonEntities);

        List<ChiTietHoaDonEntity> chiTietHoaDonEntities = chiTietHoaDonService.layAllChiTietHoaDon();
        modelMap.addAttribute("listChiTiet", chiTietHoaDonEntities);
        return "tatcadonhang";
    }
}
