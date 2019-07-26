package com.danghuy.service.impl;

import com.danghuy.dao.KhuyenMaiDAO;
import com.danghuy.entity.KhuyenMaiEntity;
import com.danghuy.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class KhuyenMaiServiceImpl implements KhuyenMaiService {
    @Autowired
    KhuyenMaiDAO khuyenMaiDAO;

    @Override
    public List<KhuyenMaiEntity> getAllKhuyenMai() {
        return khuyenMaiDAO.getAllKhuyenMai();
    }
}
