package com.danghuy.dao;

import com.danghuy.entity.DanhMucSanPhamEntity;
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
public class DanhMucSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<DanhMucSanPhamEntity> layDanhMucSanPham() {
        Session session = sessionFactory.getCurrentSession().getSession();
        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = session.createQuery("from DanhMucSanPhamEntity").list();
        return danhMucSanPhamEntities;
    }

    @Transactional
    public void saveDanhMucSanPham(String tenDanhMuc) {
        Session session = sessionFactory.getCurrentSession().getSession();
        DanhMucSanPhamEntity danhMucSanPhamEntity = new DanhMucSanPhamEntity();
        danhMucSanPhamEntity.setTenDanhMuc(tenDanhMuc);
        session.save(danhMucSanPhamEntity);
    }
}
