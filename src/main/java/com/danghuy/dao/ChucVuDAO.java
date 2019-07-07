package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.pojo.ChucVu;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class ChucVuDAO {
    @Autowired
    SessionFactory sessionFactory;

    public ChucVuEntity getTenChucVu(Integer id) {
        Session session = sessionFactory.getCurrentSession().getSession();
        String sql = "from ChucVuEntity where id = " + id;
        ChucVuEntity chucVuEntity = (ChucVuEntity) session.createQuery(sql).getSingleResult();
        return chucVuEntity;
    }

    public void addChucVu(int id, String tenChucVu) {
        Session session = sessionFactory.getCurrentSession().getSession();
        ChucVuEntity chucVuEntity = new ChucVuEntity(id, tenChucVu);
        session.save(chucVuEntity);
    }
}
