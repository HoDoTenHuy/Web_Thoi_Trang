package com.danghuy.service;

import com.danghuy.entity.ChiTietSanPhamEntity;

import java.util.List;

public interface ChiTietSanPhamService {
    public ChiTietSanPhamEntity layChiTietSanPhamByID(int idChiTietSanPham);

    public List<ChiTietSanPhamEntity> getAllChiTietSanPham();
}
