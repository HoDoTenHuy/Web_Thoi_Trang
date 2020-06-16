package com.danghuy.commons;

import com.danghuy.entity.GioHang;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.GooglePojo;
import com.danghuy.service.NhanVienService;
import com.danghuy.service.impl.NhanVienServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.util.List;

@Component
public class SaveSession {
    @Autowired
    NhanVienServiceImpl nhanVienService;

    public void loginUser(HttpSession httpSession, ModelMap modelMap) {
        String chuCaiDau;
        if (httpSession.getAttribute("user") != null) {
            String email = (String) httpSession.getAttribute("user");
            modelMap.addAttribute("email", email);
            chuCaiDau = email.substring(0, 1).toUpperCase();
        } else {
            chuCaiDau = null;
        }
        modelMap.addAttribute("chuCaiDau", chuCaiDau);

    }

    public void shoppingCart(HttpSession httpSession, ModelMap modelMap) {
        int soSanPham;
        if (httpSession.getAttribute("cart") != null) {
            List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
            soSanPham = gioHangs.size();
        } else {
            soSanPham = 0;
        }
        modelMap.addAttribute("sosanpham", soSanPham);
    }

    public void chucVu(HttpSession httpSession, ModelMap modelMap) {
        if (httpSession.getAttribute("user") != null) {
            String email = (String) httpSession.getAttribute("user");
            NhanVienEntity nhanVienEntity = nhanVienService.getUserByEmailLogin(email);
            modelMap.addAttribute("chucvu", nhanVienEntity.getChucVuEntities());
        }
    }

    public void loginGG(HttpSession httpSession, ModelMap modelMap) {
        if (httpSession.getAttribute("google") != null) {
            GooglePojo googlePojo = (GooglePojo) httpSession.getAttribute("google");
            String email = googlePojo.getEmail();
            String chuCaiDau = email.substring(0, 1).toUpperCase();
            modelMap.addAttribute("chu", chuCaiDau);
            modelMap.addAttribute("google", googlePojo);
        }
    }

    public void loginFB(HttpSession httpSession, ModelMap modelMap) {
        if (httpSession.getAttribute("facebook") != null) {
            GooglePojo googlePojo = (GooglePojo) httpSession.getAttribute("facebook");
            String email = googlePojo.getEmail();
            String chuCaiDau = email.substring(0, 1).toUpperCase();
            modelMap.addAttribute("chuDau", chuCaiDau);
            modelMap.addAttribute("facebook", googlePojo);
        }
    }

    public List<GioHang> gioHangList(HttpSession httpSession) {
        List<GioHang> gioHangs = null;
        if (httpSession.getAttribute("cart") != null) {
            gioHangs = (List<GioHang>) httpSession.getAttribute("cart");
            return gioHangs;
        }
        return gioHangs;
    }
}
