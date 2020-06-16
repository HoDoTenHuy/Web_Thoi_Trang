package com.danghuy.service;

import com.danghuy.entity.HoaDonEntity;

import java.util.List;

public interface HoaDonService {
    public int themHoaDon(HoaDonEntity hoaDonEntity);

    public List<HoaDonEntity> layAllHoaDon();

    public void duyetDonHang(int idHoaDon);
}
