package com.danghuy.controller;

import com.danghuy.entity.ChiTietHoaDonEntity;
import com.danghuy.entity.ChiTietHoaDonIDEntity;
import com.danghuy.entity.GioHang;
import com.danghuy.entity.HoaDonEntity;
import com.danghuy.service.impl.ChiTietHoaDonServiceImpl;
import com.danghuy.service.impl.HoaDonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    ChiTietHoaDonServiceImpl chiTietHoaDonService;

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

    @PostMapping
    @Transactional
    public String pageHoaDon(@RequestParam String tenKhachHang,@RequestParam String soDienThoai,
                             @RequestParam String diaChiGiaoHang,@RequestParam String hinhThucGiaoHang,
                             @RequestParam String ghiChu, HttpSession httpSession, ModelMap modelMap){
        if(httpSession.getAttribute("cart") != null){

            List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("cart");

            HoaDonEntity hoaDonEntity = new HoaDonEntity(tenKhachHang, soDienThoai, diaChiGiaoHang,
                    hinhThucGiaoHang, ghiChu);
            int idHoaDon = hoaDonService.themHoaDon(hoaDonEntity);
            if(idHoaDon > 0){
                Set<ChiTietHoaDonEntity> chiTietHoaDonEntityList = new HashSet<ChiTietHoaDonEntity>();
                for(GioHang gioHang : gioHangs){
                    ChiTietHoaDonIDEntity chiTietHoaDonIDEntity = new ChiTietHoaDonIDEntity();
                    chiTietHoaDonIDEntity.setIdChiTietSanPham(gioHang.getMaChiTiet());
                    chiTietHoaDonIDEntity.setIdHoaDon(hoaDonEntity.getIdHoaDon());

                    ChiTietHoaDonEntity chiTietHoaDonEntity = new ChiTietHoaDonEntity();
                    chiTietHoaDonEntity.setChiTietHoaDonIDEntity(chiTietHoaDonIDEntity);
                    chiTietHoaDonEntity.setGiaTien(gioHang.getGiaTien().toString());
                    chiTietHoaDonEntity.setSoLuong(gioHang.getSoLuong());

                    chiTietHoaDonService.themChiTietHoaDon(chiTietHoaDonEntity);
                }
                System.out.println("Success!");
            }else{
                System.out.println("Failed!");
            }
        }
        return "giohang";
    }
}
