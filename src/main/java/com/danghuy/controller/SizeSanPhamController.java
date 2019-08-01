package com.danghuy.controller;

import com.danghuy.entity.SizeSanPhamEntity;
import com.danghuy.service.impl.SizeSanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/themsize")
public class SizeSanPhamController {
    @Autowired
    SizeSanPhamServiceImpl sizeSanPhamService;

    @GetMapping
    public String pageDefault(ModelMap modelMap){
        List<SizeSanPhamEntity> sizeSanPhamEntities = sizeSanPhamService.layDanhSachSize();
        modelMap.addAttribute("listSize", sizeSanPhamEntities);
        return "themsizesanpham";
    }
}
