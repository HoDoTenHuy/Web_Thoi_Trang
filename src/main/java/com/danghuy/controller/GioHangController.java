package com.danghuy.controller;

import com.danghuy.entity.GioHang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
    @GetMapping
    public String pageDefault(HttpSession httpSession, ModelMap modelMap){
        if(httpSession.getAttribute("cart") != null){
            List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
            int soSanPham = gioHangs.size();
            modelMap.addAttribute("listGioHang", gioHangs);
            modelMap.addAttribute("sosanpham", soSanPham);
        }
        return "giohang";
    }
}
