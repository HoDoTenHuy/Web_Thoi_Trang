package com.danghuy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "nhanvien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNhanVien;
    private String hoTen;
    private String diaChi;
    private String gioiTinh;
    private String CMND;
    private String email;
    private int enabled;

    @Column(name = "tendangnhap")
    private String tenDangNhap;

    @Column(name = "matkhau")
    private String matKhau;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role", nullable = false)})
    @JsonIgnore
    private List<ChucVuEntity> chucVuEntities;

    public NhanVienEntity(String email, String matKhau) {
        this.email = email;
        this.matKhau = matKhau;
    }

    public NhanVienEntity(String email, int enabled, String matKhau, List<ChucVuEntity> chucVuEntities) {
        this.email = email;
        this.enabled = enabled;
        this.matKhau = matKhau;
        this.chucVuEntities = chucVuEntities;
    }

    public NhanVienEntity() {
    }

    public List<ChucVuEntity> getChucVuEntities() {
        return chucVuEntities;
    }

    public void setChucVuEntities(List<ChucVuEntity> chucVuEntities) {
        this.chucVuEntities = chucVuEntities;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
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
