package com.danghuy.dao;

import com.danghuy.entity.ChiTietSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public List<ChiTietSanPhamEntity> getAllChiTietSanPham(){
        Session session = sessionFactory.getCurrentSession().getSession();
        List<ChiTietSanPhamEntity> chiTietSanPhamEntities = session.createQuery("from ChiTietSanPhamEntity").list();
        return chiTietSanPhamEntities;
    }
}
