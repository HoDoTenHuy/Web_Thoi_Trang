package com.danghuy.dao;

import com.danghuy.entity.ChiTietHoaDonEntity;
import com.danghuy.entity.ChiTietHoaDonIDEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ChiTietHoaDonDAO {
    @Autowired
    SessionFactory sessionFactory;

    public boolean themChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        ChiTietHoaDonIDEntity id = (ChiTietHoaDonIDEntity) session.save(chiTietHoaDonEntity);
        if (id.getIdChiTietSanPham() > 0) {
            return true;
        }
            return false;
    }
}
