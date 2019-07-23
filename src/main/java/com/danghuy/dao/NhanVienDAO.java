package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.service.impl.ChucVuServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    ChucVuServiceImpl chucVuService;

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
        List<ChucVuEntity> chucVuEntities = new ArrayList<ChucVuEntity>();
        chucVuEntities.add(chucVuService.chucVuEntities().get(0));
        nhanVienEntity.setEnabled(1);
        nhanVienEntity.setChucVuEntities(chucVuEntities);
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
