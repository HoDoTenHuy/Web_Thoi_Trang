package com.danghuy.controller;

import com.danghuy.commons.SaveSession;
import com.danghuy.entity.*;
import com.danghuy.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("giohang/")
public class GioHangController {
    @Autowired
    HoaDonServiceImpl hoaDonService;

    @Autowired
    ChiTietHoaDonServiceImpl chiTietHoaDonService;

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SaveSession saveSession;

    @Autowired
    APIController apiController;

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    KhuyenMaiServiceImpl khuyenMaiService;

    @GetMapping
    @Transactional
    public String pageDefault(HttpSession httpSession, ModelMap modelMap) {
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        saveSession.chucVu(httpSession, modelMap);

        saveSession.loginGG(httpSession, modelMap);

        saveSession.loginFB(httpSession, modelMap);

        List<GioHang> gioHangs = saveSession.gioHangList(httpSession);
        modelMap.addAttribute("listGioHang", gioHangs);

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);
        return "giohang";
    }

}
