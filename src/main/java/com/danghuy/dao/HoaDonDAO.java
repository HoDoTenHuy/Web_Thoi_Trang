package com.danghuy.dao;

import com.danghuy.entity.HoaDonEntity;
import com.danghuy.service.impl.HoaDonServiceImpl;
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
public class HoaDonDAO {
    @Autowired
    SessionFactory sessionFactory;

    public int themHoaDon(HoaDonEntity hoaDonEntity) {
        Session session = sessionFactory.getCurrentSession().getSession();
        Integer id = (Integer) session.save(hoaDonEntity);
        if (id > 0) {
            return id;
        }
        return 0;
    }

    @Transactional
    public List<HoaDonEntity> layAllHoaDon(){
        Session session = sessionFactory.getCurrentSession().getSession();
        List<HoaDonEntity> hoaDonEntities = (List<HoaDonEntity>) session.createQuery("from HoaDonEntity").list();
        return hoaDonEntities;
    }

    @Transactional
    public HoaDonEntity layHoaDonTheoID(int id){
        Session session = sessionFactory.getCurrentSession().getSession();
        HoaDonEntity hoaDon = (HoaDonEntity) session.createQuery("from HoaDonEntity where idHoaDon = " + id).uniqueResult();
        return hoaDon;
    }

    @Transactional
    public void duyetDonHang(int idHoaDon){
        Session session = sessionFactory.getCurrentSession().getSession();
        HoaDonEntity hoaDonEntity = layHoaDonTheoID(idHoaDon);
        hoaDonEntity.setTinhTrang(1);
        session.update(hoaDonEntity);
    }
}
