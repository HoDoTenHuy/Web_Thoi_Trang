package com.danghuy.controller;

import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.entity.MauSanPhamEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.entity.SizeSanPhamEntity;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.MauSanPhamServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import com.danghuy.service.impl.SizeSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    MauSanPhamServiceImpl mauSanPhamService;

    @Autowired
    SizeSanPhamServiceImpl sizeSanPhamService;

    @GetMapping
    @Transactional
    public String pageDefault(ModelMap modelMap){
        List<SanPhamEntity> sanPhamEntities = sanPhamService.laySanPhamLimit(0, 5);
        List<SanPhamEntity> allSanPham = sanPhamService.layALLSanPham();
        double tongSoPage = (double) allSanPham.size()/5;
        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        List<MauSanPhamEntity> mauSanPhamEntities = mauSanPhamService.layDanhSachMau();
        List<SizeSanPhamEntity> sizeSanPhamEntities = sizeSanPhamService.layDanhSachSize();

        modelMap.addAttribute("listSize", sizeSanPhamEntities);
        modelMap.addAttribute("listMau", mauSanPhamEntities);
        modelMap.addAttribute("listDanhMucSanPham", danhMucSanPhamEntities);
        modelMap.addAttribute("tongPage", (int) Math.ceil(tongSoPage));
        modelMap.addAttribute("allSanPham", allSanPham);
        modelMap.addAttribute("listSanPham", sanPhamEntities);
        return "themsanpham";
    }
}
