package com.danghuy.controller;

import com.danghuy.commons.CheckGiamGia;
import com.danghuy.commons.SaveSession;
import com.danghuy.entity.*;
import com.danghuy.service.impl.DanhMucSanPhamServiceImpl;
import com.danghuy.service.impl.KhuyenMaiServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/chitiet")
public class ChiTietController {
    @Autowired
    SanPhamServiceImpl sanPhamService;

    @Autowired
    DanhMucSanPhamServiceImpl danhMucSanPhamService;

    @Autowired
    SaveSession saveSession;

    @Autowired
    KhuyenMaiServiceImpl khuyenMaiService;

    @Autowired
    CheckGiamGia checkGiamGia;

    @GetMapping("/{idSanPham}")
    @Transactional
    public String pageDefault(@PathVariable int idSanPham, ModelMap modelMap, HttpSession httpSession){
        saveSession.loginUser(httpSession, modelMap);

        saveSession.shoppingCart(httpSession, modelMap);

        saveSession.chucVu(httpSession, modelMap);

        saveSession.loginGG(httpSession, modelMap);

        saveSession.loginFB(httpSession, modelMap);

        SanPhamEntity sanPhamEntity = sanPhamService.layDanhSachSanPhamTheoID(idSanPham);
        modelMap.addAttribute("chiTietSanPham", sanPhamEntity);

        checkGiamGia.giaKhyenMai(sanPhamEntity, idSanPham, modelMap);

        return "chitiet";
    }

}
