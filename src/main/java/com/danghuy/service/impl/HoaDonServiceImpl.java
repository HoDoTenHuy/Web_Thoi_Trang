package com.danghuy.service.impl;

import com.danghuy.dao.HoaDonDAO;
import com.danghuy.entity.HoaDonEntity;
import com.danghuy.service.HoaDonService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HoaDonServiceImpl implements HoaDonService {
    @Autowired
    HoaDonDAO hoaDonDAO;

    public int themHoaDon(HoaDonEntity hoaDonEntity) {

        return hoaDonDAO.themHoaDon(hoaDonEntity);
    }

    @Override
    public List<HoaDonEntity> layAllHoaDon() {
        return hoaDonDAO.layAllHoaDon();
    }

    @Override
    public void duyetDonHang(int idHoaDon) {
        hoaDonDAO.duyetDonHang(idHoaDon);
    }
}
