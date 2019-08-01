package com.danghuy.dao;

import com.danghuy.entity.ChiTietSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class ChiTietSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public ChiTietSanPhamEntity layChiTietSanPhamByID(int idChiTietSanPham){
        Session session = sessionFactory.getCurrentSession().getSession();
        ChiTietSanPhamEntity chiTietSanPhamEntity = (ChiTietSanPhamEntity)
                session.createQuery("from ChiTietSanPhamEntity where idChiTietSanPham = " + idChiTietSanPham);
        return chiTietSanPhamEntity;
    }
}
