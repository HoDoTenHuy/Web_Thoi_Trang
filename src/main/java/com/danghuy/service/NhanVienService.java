package com.danghuy.service;

import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.NhanVien;

public interface NhanVienService {
    public boolean xuLyDangNhap(String username, String password);

    public boolean dangKy(NhanVien nhanVien);

    public boolean checkEmailIsValid(String email);

    public NhanVienEntity getUserByEmailLogin(String email);
}
