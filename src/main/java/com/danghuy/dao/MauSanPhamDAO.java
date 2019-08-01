package com.danghuy.dao;

import com.danghuy.entity.MauSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MauSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<MauSanPhamEntity> layDanhSachMau() {
        Session session = sessionFactory.getCurrentSession().getSession();
        List<MauSanPhamEntity> mauSanPhamEntities = session.createQuery("from MauSanPhamEntity").list();
        return mauSanPhamEntities;
    }

    @Transactional
    public void saveMauSanPham(String tenMau){
        Session session = sessionFactory.getCurrentSession().getSession();
        MauSanPhamEntity mauSanPhamEntity = new MauSanPhamEntity();
        mauSanPhamEntity.setTenMau(tenMau);
        session.save(mauSanPhamEntity);
    }
}
