package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.pojo.NhanVien;
import com.danghuy.service.impl.ChucVuServiceImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
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

    @Transactional
    public NhanVienEntity getUserByEmailLogin(String email) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from NhanVienEntity where email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        NhanVienEntity nhanVienEntity = (NhanVienEntity) query.getSingleResult();
        return nhanVienEntity;
    }

    @Transactional
    public NhanVienEntity getUserByID(int id) {
        Session session = sessionFactory.getCurrentSession().getSession();
        NhanVienEntity nhanVienEntity =
           (NhanVienEntity) session.createQuery("from NhanVienEntity where idNhanVien = " + id).getSingleResult();
        return nhanVienEntity;
    }

    @Transactional
    public List<NhanVienEntity> getAllNhanVien() {
        Session session = sessionFactory.getCurrentSession().getSession();
        List<NhanVienEntity> nhanVienEntityList = session.createQuery("from NhanVienEntity").list();
        return nhanVienEntityList;
    }

    @Transactional
    public void updateNhanVien(NhanVienEntity nhanVienEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        session.update(nhanVienEntity);
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

    @Transactional
    public List<NhanVienEntity> getNhanVienLimit(int nvDau, int nvCuoi) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from NhanVienEntity";
        Query query = session.createQuery(hql);
        query.setFirstResult(nvDau);
        query.setMaxResults(nvCuoi);
        List<NhanVienEntity> nhanVienEntities = ((org.hibernate.query.Query) query).list();
        return nhanVienEntities;
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
