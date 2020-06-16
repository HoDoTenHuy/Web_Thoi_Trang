package com.danghuy.controller;

import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/themdanhmuc")
public class ThemDanhMucController {
    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @GetMapping
    public String pageDefault(ModelMap modelMap) {
        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);
        return "themdanhmuc";
    }
}
