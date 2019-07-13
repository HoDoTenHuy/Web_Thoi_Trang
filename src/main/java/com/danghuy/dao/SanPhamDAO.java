package com.danghuy.dao;

import com.danghuy.entity.SanPhamEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class SanPhamDAO {

    @Autowired
    SessionFactory sessionFactory;

    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity";
        Query query = session.createQuery(hql);
        query.setFirstResult(spDau);
        query.setMaxResults(20);
        List<SanPhamEntity> sanPhamEntities = ((org.hibernate.query.Query) query).list();
        return sanPhamEntities;
    }

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity where idSanPham = '" + idSanPham + "'";
        SanPhamEntity sanPhamEntity = (SanPhamEntity) session.createQuery(hql).getSingleResult();
        return sanPhamEntity;
    }

    public List<SanPhamEntity> laySanPhamTheoMaDanhMuc(int maDanhMuc) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity where idDanhMuc = '" + maDanhMuc + "'";
        List<SanPhamEntity> sanPhamEntities = session.createQuery(hql).list();
        return sanPhamEntities;
    }

    public List<SanPhamEntity> layALLSanPham() {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity";
        List<SanPhamEntity> sanPhamEntities = session.createQuery(hql).list();
        return sanPhamEntities;
    }
}
