package com.danghuy.service;

import com.danghuy.entity.KhuyenMaiEntity;

import java.util.List;

public interface KhuyenMaiService {
    public List<KhuyenMaiEntity> getAllKhuyenMai();

    public KhuyenMaiEntity getKhuyenMaiByID(int idKhuyenMai);
}
