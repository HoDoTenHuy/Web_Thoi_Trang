package com.danghuy.entity;

import javax.persistence.*;

@Entity
@Table(name = "chitietsanpham")
public class ChiTietSanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChiTietSanPham;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSanPham")
    SanPhamEntity sanPhamEntity;

    @OneToOne()
    @JoinColumn(name = "idSize")
    SizeSanPhamEntity sizeSanPhamEntity;

    @OneToOne()
    @JoinColumn(name = "idMau")
    MauSanPhamEntity mauSanPhamEntity;

    private int soLuong;
    private String ngayNhap;

    public SanPhamEntity getSanPhamEntity() {
        return sanPhamEntity;
    }

    public void setSanPhamEntity(SanPhamEntity sanPhamEntity) {
        this.sanPhamEntity = sanPhamEntity;
    }

    public SizeSanPhamEntity getSizeSanPhamEntity() {
        return sizeSanPhamEntity;
    }

    public void setSizeSanPhamEntity(SizeSanPhamEntity sizeSanPhamEntity) {
        this.sizeSanPhamEntity = sizeSanPhamEntity;
    }

    public MauSanPhamEntity getMauSanPhamEntity() {
        return mauSanPhamEntity;
    }

    public void setMauSanPhamEntity(MauSanPhamEntity mauSanPhamEntity) {
        this.mauSanPhamEntity = mauSanPhamEntity;
    }

    public int getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(int idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }
}
