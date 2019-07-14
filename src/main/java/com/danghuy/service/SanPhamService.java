package com.danghuy.service;

import com.danghuy.entity.SanPhamEntity;

import java.util.List;

public interface SanPhamService {
    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi);

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham);

    public List<SanPhamEntity> laySanPhamTheoMaDanhMuc(int maDanhMuc);

    public List<SanPhamEntity> layALLSanPham();

    public void xoaSanPhamTheoID(int maSanPham);
}
