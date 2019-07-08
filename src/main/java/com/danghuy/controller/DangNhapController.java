package com.danghuy.controller;

import com.danghuy.entity.NhanVienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("dangnhap/")
public class DangNhapController {
    @Autowired
    SessionFactory sessionFactory;

    @GetMapping
    public String pageDefault() {

        return "dangnhap";
    }

    @PostMapping
    @Transactional
    public String xuLyDangNhap(@RequestParam String username, @RequestParam String password) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "FROM NhanVienEntity WHERE email = '" + username + "' AND matKhau = '" + password + "'";
        try {
            NhanVienEntity user = (NhanVienEntity) session.createQuery(hql).getSingleResult();
            if (user != null) {
                System.out.println("Hello " + user.getHoTen());
            }
        } catch (Exception e) {
            System.out.println("Login Failed!");
        }
        return "dangnhap";
    }
}
