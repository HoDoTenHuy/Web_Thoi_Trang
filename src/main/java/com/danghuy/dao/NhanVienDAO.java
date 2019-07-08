package com.danghuy.dao;

import com.danghuy.entity.NhanVienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NhanVienDAO {
    @Autowired
    SessionFactory sessionFactory;

    public boolean xuLyDangNhap(String username, String password) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "FROM NhanVienEntity WHERE email = '" + username + "' AND matKhau = '" + password + "'";
        try {
            NhanVienEntity user = (NhanVienEntity) session.createQuery(hql).getSingleResult();
            if (user != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
