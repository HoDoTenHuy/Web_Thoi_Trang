package com.danghuy.controller;

import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/danhmucsanpham/")
public class DanhMucSanPhamController {
    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @GetMapping("{idDanhMuc}")
    @Transactional
    public String pageDefault(ModelMap modelMap, @PathVariable int idDanhMuc){

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);

        List<SanPhamEntity> sanPhamEntities = sanPhamService.laySanPhamTheoMaDanhMuc(idDanhMuc);
        modelMap.addAttribute("listSanPham", sanPhamEntities);
        String tenDanhMuc = danhMucSanPhamEntities.get(idDanhMuc).getTenDanhMuc().toUpperCase();
        modelMap.addAttribute("tenDanhMuc", tenDanhMuc);
        return "sanpham";
    }
}
