package com.danghuy.controller;

import com.danghuy.entity.GioHang;
import com.danghuy.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/")
@SessionAttributes("user, cart")
public class APIController {
    private final NhanVienServiceImpl nhanVienServiceImpl;

    @Autowired
    public APIController(NhanVienServiceImpl nhanVienServiceImpl) {
        this.nhanVienServiceImpl = nhanVienServiceImpl;
    }

    List<GioHang> gioHangs = new ArrayList<GioHang>();

    @GetMapping("kiemtradangnhap")
    @ResponseBody
    @Transactional
    public String kiemTraDangNhap(@RequestParam String username, @RequestParam String password, ModelMap modelMap){
        boolean kiemTra = nhanVienServiceImpl.xuLyDangNhap(username, password);
        modelMap.addAttribute("user", username);
        return kiemTra+"";
    }

    @GetMapping("themgiohang")
    public void themGioHang(@RequestParam GioHang gioHang,
                            ModelMap modelMap, HttpSession httpSession){
        gioHangs.add(gioHang);
        httpSession.setAttribute("cart", gioHangs);
        List<GioHang> list = (List<GioHang>) httpSession.getAttribute("cart");
        System.out.println(gioHangs.size() + " - " + list.size());

    }
}
