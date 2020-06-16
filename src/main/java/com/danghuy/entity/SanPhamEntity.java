package com.danghuy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sanpham")
public class SanPhamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSanPham;

    private String tenSanPham;
    private String giaTien;
    private String moTa;
    private String hinhSanPham;
    private String gianhCho;

    @OneToOne()
    @JoinColumn(name = "idDanhMuc")
    DanhMucSanPhamEntity danhMucSanPhamEntity;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "idSanPham")
    Set<ChiTietSanPhamEntity> chiTietSanPhamEntities;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "chitietkhuyenmai",
            joinColumns = {@JoinColumn(name = "idSanPham", referencedColumnName = "idSanPham")},
            inverseJoinColumns = {@JoinColumn(name = "idKhuyenMai", referencedColumnName = "idKhuyenMai")}
    )
    @JsonIgnore
    Set<KhuyenMaiEntity> khuyenMaiEntities;

    public DanhMucSanPhamEntity getDanhMucSanPhamEntity() {
        return danhMucSanPhamEntity;
    }

    public void setDanhMucSanPhamEntity(DanhMucSanPhamEntity danhMucSanPhamEntity) {
        this.danhMucSanPhamEntity = danhMucSanPhamEntity;
    }

    public Set<ChiTietSanPhamEntity> getChiTietSanPhamEntities() {
        return chiTietSanPhamEntities;
    }

    public void setChiTietSanPhamEntities(Set<ChiTietSanPhamEntity> chiTietSanPhamEntities) {
        this.chiTietSanPhamEntities = chiTietSanPhamEntities;
    }

    public Set<KhuyenMaiEntity> getKhuyenMaiEntities() {
        return khuyenMaiEntities;
    }

    public void setKhuyenMaiEntities(Set<KhuyenMaiEntity> khuyenMaiEntities) {
        this.khuyenMaiEntities = khuyenMaiEntities;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHinhSanPham() {
        return hinhSanPham;
    }

    public void setHinhSanPham(String hinhSanPham) {
        this.hinhSanPham = hinhSanPham;
    }

    public String getGianhCho() {
        return gianhCho;
    }

    public void setGianhCho(String gianhCho) {
        this.gianhCho = gianhCho;
    }
}
