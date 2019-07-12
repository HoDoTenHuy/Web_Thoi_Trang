package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public boolean dangKy(NhanVienEntity nhanVienEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        Integer maNhanVien = (Integer) session.save(nhanVienEntity);
        if (maNhanVien > 0) {
            return true;
        } else
            return false;
    }

    public boolean checkEmailIsValid(String email) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "FROM NhanVienEntity";
        try {
            List<NhanVienEntity> User = (List<NhanVienEntity>) session.createQuery(hql).list();
            for (NhanVienEntity value : User) {
                if (value.getEmail().equals(email)) {
                    return true;
                } else
                    return false;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
