package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TrangChuController {

    @RequestMapping("/")
    public String viewTrangChu(ModelMap modelMap) {

        String username = "danghuyvms@gmail.com";
        String password = "danghuy998";
        NhanVienEntity nhanVienEntity = new NhanVienEntity();

        NhanVienEntity nhanVienEntity1 = new NhanVienEntity("KZ", "Huế", 21);

        nhanVienEntity.setTenNhanVien("Thảo hay ghen!");
        nhanVienEntity.setTuoi(21);
        nhanVienEntity.setDiaChi("Quảng Nôm....");

        List<NhanVienEntity> nhanVienList = new ArrayList<NhanVienEntity>();
        nhanVienList.add(nhanVienEntity);
        nhanVienList.add(nhanVienEntity1);


        modelMap.addAttribute("listNV", nhanVienList);
        modelMap.addAttribute("nhanVien", nhanVienEntity);
        modelMap.addAttribute("username", username);
        modelMap.addAttribute("password", password);
        return "trangchu";
    }

    @RequestMapping("/login")
    public String pageLogin() {

        return "login";
    }
}
