package com.danghuy.service.impl;

import com.danghuy.commons.conveter.EntityToPojo;
import com.danghuy.dao.SanPhamDAO;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.pojo.SanPham;
import com.danghuy.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SanPhamServiceImpl implements SanPhamService {
    @Autowired
    SanPhamDAO sanPhamDAO;


    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi) {
        return sanPhamDAO.laySanPhamLimit(spDau, spCuoi);
    }

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham) {
        return sanPhamDAO.layDanhSachSanPhamTheoID(idSanPham);
    }


    public List<SanPhamEntity> laySanPhamTheoMaDanhMuc(int maDanhMuc) {
        return sanPhamDAO.laySanPhamTheoMaDanhMuc(maDanhMuc);
    }

    public List<SanPhamEntity> layALLSanPham() {

        return sanPhamDAO.layALLSanPham();
    }

    public void xoaSanPhamTheoID(int maSanPham) {
        sanPhamDAO.xoaSanPhamTheoID(maSanPham);
    }

    public boolean themSanPham(SanPhamEntity sanPhamEntity) {
        return sanPhamDAO.themSanPham(sanPhamEntity);
    }

    public void updateSanPham(SanPhamEntity sanPhamEntity) {
        sanPhamDAO.updateSanPham(sanPhamEntity);
    }

    public List<SanPhamEntity> getSanPhamShow() {
        return sanPhamDAO.getSanPhamShow();
    }
}
