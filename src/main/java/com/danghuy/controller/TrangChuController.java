package com.danghuy.controller;

import com.danghuy.entity.GioHang;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.SanPhamService;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    SanPhamService sanPhamService;

    @GetMapping
    @Transactional
    public String pageDefault(ModelMap modelMap, HttpSession httpSession){
        if(httpSession.getAttribute("user") != null){
            String email = (String) httpSession.getAttribute("user");
            String chuCaiDau = email.substring(0 , 1).toUpperCase();
            modelMap.addAttribute("chuCaiDau", chuCaiDau);

        }
        List<SanPhamEntity> sanPhamEntities = sanPhamService.laySanPhamLimit(0, 20);
        modelMap.addAttribute("sanPhamList", sanPhamEntities);

        if(httpSession.getAttribute("cart") != null){
            List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
            int soSanPham = gioHangs.size();
            modelMap.addAttribute("sosanpham", soSanPham);
        }
        return "trangchu";
    }


}
