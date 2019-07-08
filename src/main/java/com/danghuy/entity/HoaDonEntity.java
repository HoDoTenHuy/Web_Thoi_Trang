package com.danghuy.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "hoadon")
public class HoaDonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;

    private String tenKhachHang;
    private String soDienThoai;
    private String diaChiGiaoHang;
    private boolean tinhTrang;
    private String ngayLap;
    private String hinhThucGiaoHang;
    private String ghiChu;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHoaDon")
    Set<ChiTietHoaDonEntity> chiTietHoaDonEntities;

    public Set<ChiTietHoaDonEntity> getChiTietHoaDonEntities() {
        return chiTietHoaDonEntities;
    }

    public void setChiTietHoaDonEntities(Set<ChiTietHoaDonEntity> chiTietHoaDonEntities) {
        this.chiTietHoaDonEntities = chiTietHoaDonEntities;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public String getHinhThucGiaoHang() {
        return hinhThucGiaoHang;
    }

    public void setHinhThucGiaoHang(String hinhThucGiaoHang) {
        this.hinhThucGiaoHang = hinhThucGiaoHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
