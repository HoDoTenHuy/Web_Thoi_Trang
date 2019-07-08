package com.danghuy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "khuyenmai")
public class KhuyenMaiEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKhuyenMai;
    private String tenKhuyenMai;
    private String thoiGianBatDau;
    private String thoiGianKetThuc;
    private String moTa;
    private String hinhKhuyenMai;
    private int giamGia;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "chitietkhuyenmai",
            joinColumns = {@JoinColumn(name = "idKhuyenMai", referencedColumnName = "idKhuyenMai")},
            inverseJoinColumns = {@JoinColumn(name = "idSanPham", referencedColumnName = "idSanPham")}
    )
    Set<SanPhamEntity> sanPhamEntities;

    public Set<SanPhamEntity> getSanPhamEntities() {
        return sanPhamEntities;
    }

    public void setSanPhamEntities(Set<SanPhamEntity> sanPhamEntities) {
        this.sanPhamEntities = sanPhamEntities;
    }

    public int getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(int idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public String getTenKhuyenMai() {
        return tenKhuyenMai;
    }

    public void setTenKhuyenMai(String tenKhuyenMai) {
        this.tenKhuyenMai = tenKhuyenMai;
    }

    public String getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
        return thoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
        this.thoiGianKetThuc = thoiGianKetThuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhKhuyenMai() {
        return hinhKhuyenMai;
    }

    public void setHinhKhuyenMai(String hinhKhuyenMai) {
        this.hinhKhuyenMai = hinhKhuyenMai;
    }

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }
}
