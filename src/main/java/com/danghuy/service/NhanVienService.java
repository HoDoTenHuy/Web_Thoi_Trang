package com.danghuy.service;

import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.NhanVien;

import java.util.List;

public interface NhanVienService {
    public boolean xuLyDangNhap(String username, String password);

    public boolean dangKy(NhanVien nhanVien);

    public boolean checkEmailIsValid(String email);

    public NhanVienEntity getUserByEmailLogin(String email);

    public List<NhanVienEntity> getAllNhanVien();

    public NhanVienEntity getUserByID(int id);

    public void updateNhanVien(NhanVienEntity nhanVienEntity);

    public List<NhanVienEntity> getNhanVienLimit(int nvDau, int nvCuoi);
}
