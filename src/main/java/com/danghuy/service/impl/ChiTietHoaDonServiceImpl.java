package com.danghuy.service.impl;

import com.danghuy.dao.ChiTietHoaDonDAO;
import com.danghuy.entity.ChiTietHoaDonEntity;
import com.danghuy.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHoaDonServiceImpl implements ChiTietHoaDonService {
    @Autowired
    ChiTietHoaDonDAO chiTietHoaDonDAO;
    public boolean themChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity) {
        return chiTietHoaDonDAO.themChiTietHoaDon(chiTietHoaDonEntity);
    }
}
