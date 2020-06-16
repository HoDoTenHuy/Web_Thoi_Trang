package com.danghuy.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "hoadon")
public class HoaDonEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHoaDon;

    private String tenKhachHang;
    private String soDienThoai;
    private String diaChiGiaoHang;
    private int tinhTrang;
    private String ngayLap;
    private String hinhThucGiaoHang;
    private String ghiChu;
    private String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idHoaDon")
    Set<ChiTietHoaDonEntity> chiTietHoaDonEntities;

    public HoaDonEntity() {
    }

    public HoaDonEntity(String tenKhachHang, String soDienThoai, String diaChiGiaoHang, int tinhTrang,
                        String ngayLap, String hinhThucGiaoHang, String ghiChu) {
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.tinhTrang = tinhTrang;
        this.ngayLap = ngayLap;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.ghiChu = ghiChu;
    }

    public HoaDonEntity(String tenKhachHang, String email , String soDienThoai, String diaChiGiaoHang,
                        String hinhThucGiaoHang, String ghiChu) {
        this.tenKhachHang = tenKhachHang;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.hinhThucGiaoHang = hinhThucGiaoHang;
        this.ghiChu = ghiChu;
    }

    public Set<ChiTietHoaDonEntity> getChiTietHoaDonEntities() {
        return chiTietHoaDonEntities;
    }

    public void setChiTietHoaDonEntities(Set<ChiTietHoaDonEntity> chiTietHoaDonEntities) {
        this.chiTietHoaDonEntities = chiTietHoaDonEntities;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
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
