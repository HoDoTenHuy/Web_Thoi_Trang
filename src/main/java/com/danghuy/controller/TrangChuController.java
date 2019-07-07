package com.danghuy.controller;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Set;


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

        NhanVienEntity nhanVienEntity1 = new NhanVienEntity();
        nhanVienEntity1.setHoTen("dsdsdsd");

        NhanVienEntity nhanVienEntity2 = new NhanVienEntity();
        nhanVienEntity2.setHoTen("KZ2323");

        ChucVuEntity chucVuEntity = new ChucVuEntity();
        chucVuEntity.setTenChucVu("BOSS");

        Set<NhanVienEntity> nhanVienEntities = new HashSet<NhanVienEntity>();
        nhanVienEntities.add(nhanVienEntity);
        nhanVienEntities.add(nhanVienEntity1);
        nhanVienEntities.add(nhanVienEntity2);

        chucVuEntity.setNhanVienEntities(nhanVienEntities);

        session.save(chucVuEntity);
        return "trangchu";
    }


}
