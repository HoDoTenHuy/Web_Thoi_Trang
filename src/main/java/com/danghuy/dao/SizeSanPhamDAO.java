package com.danghuy.dao;

import com.danghuy.entity.SizeSanPhamEntity;
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
public class SizeSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<SizeSanPhamEntity> layDanhSachSize() {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SizeSanPhamEntity";
        List<SizeSanPhamEntity> sizeSanPhamEntities = session.createQuery(hql).list();
        return sizeSanPhamEntities;
    }

    @Transactional
    public void saveSizeSanPham(String tenSize){
        Session session = sessionFactory.getCurrentSession().getSession();
        SizeSanPhamEntity sizeSanPhamEntity = new SizeSanPhamEntity();
        sizeSanPhamEntity.setSize(tenSize);
        session.save(sizeSanPhamEntity);
    }
}
