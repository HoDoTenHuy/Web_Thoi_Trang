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
@RequestMapping("/register")
public class DangKyController {
    private final NhanVienServiceImpl nhanVienServiceImpl;

    @Autowired
    public DangKyController(NhanVienServiceImpl nhanVienServiceImpl) {
        this.nhanVienServiceImpl = nhanVienServiceImpl;
    }

    @Autowired
    CheckEmail checkEmail;

    @GetMapping
    public String pageDefault() {
        return "register";
    }
}
