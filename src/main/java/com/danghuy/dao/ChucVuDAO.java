package com.danghuy.dao;

import com.danghuy.entity.ChucVuEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class ChucVuDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public List<ChucVuEntity> chucVuEntities(){
        Session session = sessionFactory.getCurrentSession().getSession();
        String hql = "from ChucVuEntity";
        List<ChucVuEntity> chucVuEntityList = session.createQuery(hql).list();
        return chucVuEntityList;
    }
}
