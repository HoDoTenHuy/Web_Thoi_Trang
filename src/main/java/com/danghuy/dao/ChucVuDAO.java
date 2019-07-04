package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;

@Repository
public class ChucVuDAO {
    @Autowired
    SessionFactory sessionFactory;

    public ChucVuEntity getTenChucVu(Integer id){
        Session session = sessionFactory.getCurrentSession().getSession();
        ChucVuEntity chucVuEntity = (ChucVuEntity)
                session.createQuery("FROM ChucVuEntity WHERE idChuVu = " + id).uniqueResult();
        return chucVuEntity;
    }
}
