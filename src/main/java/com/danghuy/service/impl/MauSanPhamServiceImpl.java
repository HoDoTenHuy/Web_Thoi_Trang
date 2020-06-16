package com.danghuy.service.impl;

import com.danghuy.dao.MauSanPhamDAO;
import com.danghuy.entity.MauSanPhamEntity;
import com.danghuy.service.MauSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MauSanPhamServiceImpl implements MauSanPhamService {
    @Autowired
    MauSanPhamDAO mauSanPhamDAO;

    public List<MauSanPhamEntity> layDanhSachMau() {
        return mauSanPhamDAO.layDanhSachMau();
    }

    @Override
    public void saveMauSanPham(String tenMau) {
        mauSanPhamDAO.saveMauSanPham(tenMau);
    }
}
