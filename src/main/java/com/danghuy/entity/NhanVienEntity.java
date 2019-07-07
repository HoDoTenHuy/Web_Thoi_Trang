package com.danghuy.entity;

import javax.persistence.*;

@Entity
@Table(name = "nhanvien")
public class NhanVienEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idNhanVien;
    String hoTen;
    /*private String diaChi;
    private String gioiTinh;
    private String CMND;
    private String email;
    private String tenDangNhap;
    private String matKhau;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idChucVu")
    ChucVuEntity chucVuEntity;

    public ChucVuEntity getChucVuEntity() {
        return chucVuEntity;
    }

    public void setChucVuEntity(ChucVuEntity chucVuEntity) {
        this.chucVuEntity = chucVuEntity;
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



}
