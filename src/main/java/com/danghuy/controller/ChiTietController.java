package com.danghuy.controller;

import com.danghuy.entity.ChiTietSanPhamEntity;
import com.danghuy.entity.MauSanPhamEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping("/{idSanPham}")
    @Transactional
    public String pageDefault(@PathVariable int idSanPham, ModelMap modelMap){
        SanPhamEntity sanPhamEntity = sanPhamService.layDanhSachSanPhamTheoID(idSanPham);
        modelMap.addAttribute("chiTietSanPham", sanPhamEntity);
        return "chitiet";
    }

}
