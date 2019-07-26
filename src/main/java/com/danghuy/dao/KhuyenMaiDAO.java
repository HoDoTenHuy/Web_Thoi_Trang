package com.danghuy.dao;

import com.danghuy.entity.KhuyenMaiEntity;
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
public class KhuyenMaiDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<KhuyenMaiEntity> getAllKhuyenMai(){
        Session session = sessionFactory.getCurrentSession().getSession();
        List<KhuyenMaiEntity> khuyenMaiEntityList = session.createQuery("from KhuyenMaiEntity").list();
        return khuyenMaiEntityList;
    }
}
