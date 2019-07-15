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

    @Autowired
    EntityToPojo entityToPojo;

    public List<SanPhamEntity> laySanPhamLimit(int spDau, int spCuoi) {
        return sanPhamDAO.laySanPhamLimit(spDau, spCuoi);
    }

    public SanPhamEntity layDanhSachSanPhamTheoID(int idSanPham) {
        return sanPhamDAO.layDanhSachSanPhamTheoID(idSanPham);
    }

    public SanPham layDanhSachSanPhamTheoIDConvertPojo(int idSanPham) {
        SanPhamEntity sanPhamEntity = sanPhamDAO.layDanhSachSanPhamTheoID(idSanPham);
        SanPham sanPham = entityToPojo.convertSanPham(sanPhamEntity);
        return sanPham;
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
}
