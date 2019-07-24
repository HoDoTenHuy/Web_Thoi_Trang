package com.danghuy.controller;

import com.danghuy.commons.SaveSession;
import com.danghuy.entity.*;
import com.danghuy.service.SanPhamService;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SaveSession saveSession;

    @GetMapping("/{idSanPham}")
    @Transactional
    public String pageDefault(@PathVariable int idSanPham, ModelMap modelMap, HttpSession httpSession) {
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        saveSession.chucVu(httpSession, modelMap);

        saveSession.loginGG(httpSession, modelMap);

        SanPhamEntity sanPhamEntity = sanPhamService.layDanhSachSanPhamTheoID(idSanPham);
        modelMap.addAttribute("chiTietSanPham", sanPhamEntity);

        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = danhMucSanPhamService.layDanhMucSanPham();
        modelMap.addAttribute("listDanhMuc", danhMucSanPhamEntities);

        return "chitiet";
    }

}
