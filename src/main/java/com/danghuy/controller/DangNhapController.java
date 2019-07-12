package com.danghuy.controller;

import com.danghuy.commons.CheckEmail;
import com.danghuy.pojo.NhanVien;
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

    @Autowired
    CheckEmail checkEmail;

    @GetMapping
    public String pageDefault() {

        return "dangnhap";
    }

    @PostMapping
    @Transactional
    public String dangKy(@RequestParam String email, @RequestParam String matKhau, @RequestParam String nhapLaiMatKhau
            , ModelMap modelMap) {
        if (nhanVienServiceImpl.checkEmailIsValid(email)) {
            modelMap.addAttribute("kiemtradangnhap", "Email Đã Tồn Tại!");
        } else {
            if (checkEmail.kiemTraEmail(email) && matKhau.equalsIgnoreCase(nhapLaiMatKhau)) {
                NhanVien nhanVien = new NhanVien(email, matKhau);
                if (nhanVienServiceImpl.dangKy(nhanVien)) {
                    modelMap.addAttribute("kiemtradangnhap", "Đăng Ký Thành Công!");
                } else {
                    modelMap.addAttribute("kiemtradangnhap", "Đăng Ký Thất Bại!");
                }
            } else if (checkEmail.kiemTraEmail(email) == false) {
                modelMap.addAttribute("kiemtradangnhap", "Vui Lòng Nhập Đúng Email!");
            } else if (matKhau.equalsIgnoreCase(nhapLaiMatKhau)) {
                modelMap.addAttribute("kiemtradangnhap", "Mật Khẩu Khác Nhau!");
            } else
                modelMap.addAttribute("kiemtradangnhap", "Đăng Ký Thất Bại!");
        }
        return "dangnhap";
    }
}
