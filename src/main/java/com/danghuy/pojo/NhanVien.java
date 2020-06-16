package com.danghuy.pojo;

import com.danghuy.entity.ChucVuEntity;

import java.util.List;

public class NhanVien {
    private int idNhanVien;
    private String hoTen;
    private String diaChi;
    private String gioiTinh;
    private String CMND;
    private String email;
    private String tenDangNhap;
    private String matKhau;
    private int enabled;
    private List<ChucVuEntity> chucVuEntities;

    public NhanVien(String email, String matKhau) {
        this.email = email;
        this.matKhau = matKhau;
    }

    public NhanVien() {
    }

    public NhanVien(int idNhanVien, String hoTen, String diaChi, String gioiTinh, String CMND, String email,
                    String tenDangNhap, String matKhau) {
        this.idNhanVien = idNhanVien;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.CMND = CMND;
        this.email = email;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }

    public NhanVien(String email, String matKhau, int enabled, List<ChucVuEntity> chucVuEntities) {
        this.email = email;
        this.matKhau = matKhau;
        this.enabled = enabled;
        this.chucVuEntities = chucVuEntities;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public List<ChucVuEntity> getChucVuEntities() {
        return chucVuEntities;
    }

    public void setChucVuEntities(List<ChucVuEntity> chucVuEntities) {
        this.chucVuEntities = chucVuEntities;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
