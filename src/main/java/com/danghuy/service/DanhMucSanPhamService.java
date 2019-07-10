package com.danghuy.service;

import com.danghuy.dao.DanhMucSanPhamDAO;
import com.danghuy.entity.DanhMucSanPhamEntity;

import java.util.List;

public interface DanhMucSanPhamService {
    public List<DanhMucSanPhamEntity> layDanhMucSanPham();
}
