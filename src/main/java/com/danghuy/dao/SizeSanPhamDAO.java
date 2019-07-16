package com.danghuy.dao;

import com.danghuy.entity.SizeSanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SizeSanPhamDAO {
    @Autowired
    SessionFactory sessionFactory;

    public List<SizeSanPhamEntity> layDanhSachSize(){
        Session session = sessionFactory.getCurrentSession().getSession();
        String  hql = "from SizeSanPhamEntity";
        List<SizeSanPhamEntity> sizeSanPhamEntities = session.createQuery(hql).list();
        return sizeSanPhamEntities;
    }
}
