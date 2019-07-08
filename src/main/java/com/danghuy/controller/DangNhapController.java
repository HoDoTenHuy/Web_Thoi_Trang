package com.danghuy.controller;

import com.danghuy.pojo.NhanVien;
import com.danghuy.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
    private final NhanVienService nhanVienService;

    @Autowired
    public DangNhapController(NhanVienService nhanVienService) {
        this.nhanVienService = nhanVienService;
    }

    @GetMapping
    public String pageDefault() {

        return "dangnhap";
    }

    @PostMapping
    @Transactional
    public String xuLyDangNhap(@RequestParam String username, @RequestParam String password) {
        if (nhanVienService.xuLyDangNhap(username, password)) {
            System.out.println("Login success!");
            return "redirect:/";
        } else {
            System.out.println("Login failed!");
        }
        return "dangnhap";
    }
}
