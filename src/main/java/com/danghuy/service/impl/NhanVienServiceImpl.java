package com.danghuy.service.impl;

import com.danghuy.commons.conveter.EntityToPojo;
import com.danghuy.dao.NhanVienDAO;
import com.danghuy.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NhanVienServiceImpl implements NhanVienService {
    @Autowired
    NhanVienDAO nhanVienDAO;

    @Autowired
    EntityToPojo entityToPojo;


    public boolean xuLyDangNhap(String username, String password) {
        if (nhanVienDAO.xuLyDangNhap(username, password)) {
            return true;
        } else
        return false;
    }
}
