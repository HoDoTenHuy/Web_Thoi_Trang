package com.danghuy.controller;

import com.danghuy.commons.SaveSession;
import com.danghuy.entity.*;
import com.danghuy.service.impl.ChiTietHoaDonServiceImpl;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
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

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SaveSession saveSession;

    @Autowired
    APIController apiController;

    @GetMapping
    @Transactional
    public String pageDefault(HttpSession httpSession, ModelMap modelMap) {
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        List<GioHang> gioHangs = saveSession.gioHangList(httpSession);
        modelMap.addAttribute("listGioHang", gioHangs);

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);
        return "giohang";
    }

}
