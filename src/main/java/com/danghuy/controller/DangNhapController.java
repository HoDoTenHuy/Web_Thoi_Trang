package com.danghuy.controller;

import com.danghuy.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
    private final NhanVienServiceImpl nhanVienServiceImpl;

    @Autowired
    public DangNhapController(NhanVienServiceImpl nhanVienServiceImpl) {
        this.nhanVienServiceImpl = nhanVienServiceImpl;
    }

    @GetMapping
    public String pageDefault(){

        return "dangnhap";
    }

    @PostMapping
    @Transactional
    public String xuLyDangNhap(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
        return "trangchu";
    }
}
