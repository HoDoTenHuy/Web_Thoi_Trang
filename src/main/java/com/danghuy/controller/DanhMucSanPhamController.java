package com.danghuy.controller;

import com.danghuy.commons.SaveSession;
import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.entity.GioHang;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/danhmucsanpham/")
public class DanhMucSanPhamController {
    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    SaveSession saveSession;

    @GetMapping("{idDanhMuc}")
    @Transactional
    public String pageDefault(ModelMap modelMap, @PathVariable int idDanhMuc, HttpSession httpSession) {
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        saveSession.chucVu(httpSession, modelMap);

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);

        List<SanPhamEntity> sanPhamEntities = sanPhamService.laySanPhamTheoMaDanhMuc(idDanhMuc);
        modelMap.addAttribute("listSanPham", sanPhamEntities);
        String tenDanhMuc = danhMucSanPhamEntities.get(idDanhMuc - 1).getTenDanhMuc().toUpperCase();
        modelMap.addAttribute("tenDanhMuc", tenDanhMuc);
        return "sanpham";
    }
}
