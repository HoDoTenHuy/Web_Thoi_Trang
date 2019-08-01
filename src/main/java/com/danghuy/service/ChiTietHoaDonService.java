package com.danghuy.service;

import com.danghuy.entity.ChiTietHoaDonEntity;

import java.util.List;

public interface ChiTietHoaDonService {
    public boolean themChiTietHoaDon(ChiTietHoaDonEntity chiTietHoaDonEntity);

    public List<ChiTietHoaDonEntity> layAllChiTietHoaDon();
}
