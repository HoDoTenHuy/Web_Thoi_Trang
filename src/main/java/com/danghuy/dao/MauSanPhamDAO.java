package com.danghuy.dao;

import com.danghuy.entity.MauSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MauSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<MauSanPhamEntity> layDanhSachMau(){
        Session session = sessionFactory.getCurrentSession().getSession();
        List<MauSanPhamEntity> mauSanPhamEntities = session.createQuery("from MauSanPhamEntity").list();
        return mauSanPhamEntities;
    }
}
