package com.danghuy.service.impl;

import com.danghuy.commons.CheckEmail;
import com.danghuy.commons.conveter.EntityToPojo;
import com.danghuy.commons.conveter.PojoToEntity;
import com.danghuy.dao.NhanVienDAO;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.NhanVien;
import com.danghuy.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienDAO nhanVienDAO;

    @Autowired
    EntityToPojo entityToPojo;

    @Autowired
    PojoToEntity pojoToEntity;


    public boolean xuLyDangNhap(String username, String password) {
        if (nhanVienDAO.xuLyDangNhap(username, password)) {
            return true;
        } else
            return false;
    }

    public boolean dangKy(NhanVien nhanVien) {
        NhanVienEntity nhanVienEntity = pojoToEntity.convertNhanVien(nhanVien);
        if (nhanVienDAO.dangKy(nhanVienEntity)) {
            return true;
        } else
            return false;
    }

    public boolean checkEmailIsValid(String email) {
        if (nhanVienDAO.checkEmailIsValid(email)) {
            return true;
        } else
            return false;
    }
}
