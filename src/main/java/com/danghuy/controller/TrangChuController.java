package com.danghuy.controller;

import com.danghuy.commons.RandomSanPhamShowTrangChu;
import com.danghuy.commons.SaveSession;
import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.entity.GioHang;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.pojo.GooglePojo;
import com.danghuy.service.SanPhamService;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.NhanVienServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;
import java.util.Vector;

@Controller
@RequestMapping("/")

public class TrangChuController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SaveSession saveSession;

    @Autowired
    RandomSanPhamShowTrangChu randomSanPhamShowTrangChu;

    @Autowired
    NhanVienServiceImpl nhanVienService;

    @GetMapping
    @Transactional
    public String pageDefault(ModelMap modelMap, HttpSession httpSession) {
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        saveSession.chucVu(httpSession, modelMap);

        saveSession.loginGG(httpSession, modelMap);

        saveSession.loginFB(httpSession, modelMap);

        List<SanPhamEntity> sanPhamEntities = sanPhamService.getSanPhamShow();
        modelMap.addAttribute("sanPhamList", sanPhamEntities);

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);


        return "trangchu";
    }


}
