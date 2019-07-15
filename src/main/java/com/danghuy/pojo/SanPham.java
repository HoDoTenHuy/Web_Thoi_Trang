package com.danghuy.pojo;

import com.danghuy.entity.ChiTietSanPhamEntity;
import com.danghuy.entity.DanhMucSanPhamEntity;
import com.danghuy.entity.KhuyenMaiEntity;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class SanPham {
    private int idSanPham;
    private String tenSanPham;
    private String giaTien;
    private String moTa;
    private String hinhSanPham;
    private String gianhCho;
    DanhMucSanPhamEntity danhMucSanPham;
    Set<ChiTietSanPhamEntity> chiTietSanPhams;
    Set<KhuyenMaiEntity> khuyenMaiEntities;

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

    public DanhMucSanPhamEntity getDanhMucSanPham() {
        return danhMucSanPham;
    }

    public void setDanhMucSanPham(DanhMucSanPhamEntity danhMucSanPham) {
        this.danhMucSanPham = danhMucSanPham;
    }

    public Set<ChiTietSanPhamEntity> getChiTietSanPhams() {
        return chiTietSanPhams;
    }

    public void setChiTietSanPhams(Set<ChiTietSanPhamEntity> chiTietSanPhams) {
        this.chiTietSanPhams = chiTietSanPhams;
    }

    public Set<KhuyenMaiEntity> getKhuyenMaiEntities() {
        return khuyenMaiEntities;
    }

    public void setKhuyenMaiEntities(Set<KhuyenMaiEntity> khuyenMaiEntities) {
        this.khuyenMaiEntities = khuyenMaiEntities;
    }
}
