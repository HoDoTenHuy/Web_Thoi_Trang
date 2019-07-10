package com.danghuy.dao;

import com.danghuy.entity.DanhMucSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DanhMucSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<DanhMucSanPhamEntity> layDanhMucSanPham() {
        Session session = sessionFactory.getCurrentSession().getSession();
        List<DanhMucSanPhamEntity> danhMucSanPhamEntities = session.createQuery("from DanhMucSanPhamEntity").list();
        return danhMucSanPhamEntities;
    }
}
