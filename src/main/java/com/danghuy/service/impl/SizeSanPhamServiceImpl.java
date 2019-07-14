package com.danghuy.service.impl;

import com.danghuy.dao.SizeSanPhamDAO;
import com.danghuy.entity.SizeSanPhamEntity;
import com.danghuy.service.SizeSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SizeSanPhamServiceImpl implements SizeSanPhamService {
    @Autowired
    SizeSanPhamDAO sizeSanPhamDAO;
    public List<SizeSanPhamEntity> layDanhSachSize() {
         return sizeSanPhamDAO.layDanhSachSize();
    }
}
