package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import com.danghuy.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/updatenhanvien")
public class UpdateNhanVienController {
    @Autowired
    NhanVienServiceImpl nhanVienService;

    @GetMapping
    public String defaultPgaeNV(ModelMap modelMap){
        List<NhanVienEntity> nhanVienList = nhanVienService.getAllNhanVien();
        modelMap.addAttribute("listNhanVien", nhanVienList);
        return "nhanvien";
    }
}
