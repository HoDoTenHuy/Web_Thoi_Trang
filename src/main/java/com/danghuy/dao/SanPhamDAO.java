package com.danghuy.dao;

import com.danghuy.commons.RandomSanPhamShowTrangChu;
import com.danghuy.entity.SanPhamEntity;
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
import java.util.Random;
import java.util.Vector;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    RandomSanPhamShowTrangChu randomSanPhamShowTrangChu;

    @Transactional
    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity";
        Query query = session.createQuery(hql);
        query.setFirstResult(spDau);
        query.setMaxResults(spCuoi);
        List<SanPhamEntity> sanPhamEntities = ((org.hibernate.query.Query) query).list();
        return sanPhamEntities;
    }

    @Transactional
    public List<SanPhamEntity> getSanPhamShow() {
        Session session = sessionFactory.getCurrentSession().getSession();
        int maxSanPham = layALLSanPham().size();
        List<SanPhamEntity> sanPhamEntities = new ArrayList<SanPhamEntity>();
        Vector vector = randomSanPhamShowTrangChu.vectorSanPham(maxSanPham);
        System.out.println(vector);
        for (int i = 0; i < 20; i++) {
            String hql = "from SanPhamEntity where idSanPham = " + vector.get(i);
            SanPhamEntity sanPhamEntity = (SanPhamEntity) session.createQuery(hql).uniqueResult();
            sanPhamEntities.add(sanPhamEntity);
        }
        return sanPhamEntities;
    }

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from SanPhamEntity where idSanPham = " + idSanPham;
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

    @Transactional
    public void xoaSanPhamTheoID(int maSanPham) {
        Session session = sessionFactory.getCurrentSession().getSession();
        SanPhamEntity sanPhamEntity = new SanPhamEntity();
        sanPhamEntity.setIdSanPham(maSanPham);
        session.delete(sanPhamEntity);
    }

    @Transactional
    public boolean themSanPham(SanPhamEntity sanPhamEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        Integer id = (Integer) session.save(sanPhamEntity);
        if (id > 0) {
            return true;
        }
        return false;
    }

    @Transactional
    public void updateSanPham(SanPhamEntity sanPhamEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        session.update(sanPhamEntity);
    }
}
