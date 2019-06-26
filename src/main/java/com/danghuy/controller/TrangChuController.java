package com.danghuy.controller;

import com.danghuy.entity.GiamDocEntity;
import com.danghuy.entity.NhanVienEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.Properties;

@Controller
public class TrangChuController {
    @RequestMapping("/")
    public String viewTrangChu() {
        ApplicationContext context = new ClassPathXmlApplicationContext("IoC.xml");
        NhanVienEntity nhanVienEntity = (NhanVienEntity) context.getBean("nhanvien");
        nhanVienEntity.setTenNhanVien("Huy");
        System.out.println("Nhan vien 1 : " + nhanVienEntity.getTenNhanVien());
        NhanVienEntity nhanVienEntity1 = (NhanVienEntity) context.getBean("nhanvien");
        System.out.println("Nhan vien 2 : " + nhanVienEntity1.getTenNhanVien());
        ((ClassPathXmlApplicationContext) context).close();
        return "trangchu";
    }

    @RequestMapping("/login")
    public String login() {

        return "login";
    }
}
