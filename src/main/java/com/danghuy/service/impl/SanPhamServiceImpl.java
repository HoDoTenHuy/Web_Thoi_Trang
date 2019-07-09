package com.danghuy.service.impl;

import com.danghuy.dao.SanPhamDAO;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamDAO sanPhamDAO;

    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi){
        return sanPhamDAO.laySanPhamLimit(spDau, spCuoi);
    }

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham) {
        return sanPhamDAO.layDanhSachSanPhamTheoID(idSanPham);
    }
}
