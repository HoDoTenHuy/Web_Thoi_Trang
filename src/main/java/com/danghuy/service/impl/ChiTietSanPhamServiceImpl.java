package com.danghuy.service.impl;

import com.danghuy.dao.ChiTietSanPhamDAO;
import com.danghuy.entity.ChiTietSanPhamEntity;
import com.danghuy.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamDAO chiTietSanPhamDAO;

    @Override
    public ChiTietSanPhamEntity layChiTietSanPhamByID(int idChiTietSanPham) {
        return chiTietSanPhamDAO.layChiTietSanPhamByID(idChiTietSanPham);
    }
}
