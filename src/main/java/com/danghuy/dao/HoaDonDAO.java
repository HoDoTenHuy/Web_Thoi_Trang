package com.danghuy.dao;

import com.danghuy.entity.HoaDonEntity;
import com.danghuy.service.impl.HoaDonServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO {
    @Autowired
    SessionFactory sessionFactory;

    public int themHoaDon(HoaDonEntity hoaDonEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        Integer id = (Integer) session.save(hoaDonEntity);
        if (id > 0) {
            return id;
        }
        return 0;
    }
}
