package com.danghuy.service;

import com.danghuy.entity.MauSanPhamEntity;

import java.util.List;

public interface MauSanPhamService {
    public List<MauSanPhamEntity> layDanhSachMau();

    public void saveMauSanPham(String tenMau);
}
