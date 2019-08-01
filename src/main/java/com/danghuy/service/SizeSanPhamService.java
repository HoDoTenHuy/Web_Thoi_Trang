package com.danghuy.service;

import com.danghuy.entity.SizeSanPhamEntity;

import java.util.List;

public interface SizeSanPhamService {
    public List<SizeSanPhamEntity> layDanhSachSize();

    public void saveSizeSanPham(String tenSize);
}
