package com.danghuy.dao;

import com.danghuy.entity.GopYEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GopYDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public void saveGopY(GopYEntity gopYEntity){
        Session session = sessionFactory.getCurrentSession().getSession();
        session.save(gopYEntity);
    }

    @Transactional
    public List<GopYEntity> getAllGopY(){
        Session session = sessionFactory.getCurrentSession().getSession();
        List<GopYEntity> gopYEntities = session.createQuery("from GopYEntity").list();
        return gopYEntities;
    }
}
