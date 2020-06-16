package com.danghuy.service.impl;

import com.danghuy.dao.DanhMucSanPhamDAO;
import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.service.DanhMucSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DanhMucSanPhamServiceImpl implements DanhMucSanPhamService {
    @Autowired
    DanhMucSanPhamDAO danhMucSanPhamDAO;


    public List<DanhMucSanPhamEntity> layDanhMucSanPham() {
        return danhMucSanPhamDAO.layDanhMucSanPham();
    }

    @Override
    public void saveDanhMucSanPham(String tenDanhMuc) {
        danhMucSanPhamDAO.saveDanhMucSanPham(tenDanhMuc);
    }
}
