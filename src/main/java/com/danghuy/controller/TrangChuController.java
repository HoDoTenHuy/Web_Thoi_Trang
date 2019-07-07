package com.danghuy.controller;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TrangChuController {
    @Autowired
    SessionFactory sessionFactory;

    @GetMapping
    @Transactional
    public String pageDefault(){
        Session session = sessionFactory.getCurrentSession().getSession();

        NhanVienEntity nhanVienEntity = new NhanVienEntity();
        nhanVienEntity.setHoTen("KZ1");

        ChucVuEntity chucVuEntity = new ChucVuEntity();
        chucVuEntity.setTenChucVu("BOSS");


        nhanVienEntity.setChucVuEntity(chucVuEntity);

        session.save(nhanVienEntity);
        return "trangchu";
    }


}
