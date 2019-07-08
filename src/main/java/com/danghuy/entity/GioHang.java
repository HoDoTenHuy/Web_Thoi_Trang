package com.danghuy.entity;

public class GioHang {
    int maSP;
    int maMau;
    int maSize;
    int soLuong;
    int maChiTietSP;
    String tenSP;
    String giaTien;
    String tenMau;
    String tenSize;

    public GioHang(int maSP, int maMau, int maSize, int soLuong, String tenSP, String giaTien, String tenMau, String tenSize) {
        this.maSP = maSP;
        this.maMau = maMau;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.tenMau = tenMau;
        this.tenSize = tenSize;
    }

    public GioHang() {

    }

    public GioHang(int maSP, int maMau, int maSize, int soLuong, int maChiTietSP, String tenSP, String giaTien, String tenMau, String tenSize) {
        this.maSP = maSP;
        this.maMau = maMau;
        this.maSize = maSize;
        this.soLuong = soLuong;
        this.maChiTietSP = maChiTietSP;
        this.tenSP = tenSP;
        this.giaTien = giaTien;
        this.tenMau = tenMau;
        this.tenSize = tenSize;
    }

    public int getMaChiTietSP() {
        return maChiTietSP;
    }

    public void setMaChiTietSP(int maChiTietSP) {
        this.maChiTietSP = maChiTietSP;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public int getMaMau() {
        return maMau;
    }

    public void setMaMau(int maMau) {
        this.maMau = maMau;
    }

    public int getMaSize() {
        return maSize;
    }

    public void setMaSize(int maSize) {
        this.maSize = maSize;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    public String getTenSize() {
        return tenSize;
    }

    public void setTenSize(String tenSize) {
        this.tenSize = tenSize;
    }


    @Override
    public String toString() {
        return "GioHang{" +
                "tenSP='" + tenSP + '\'' +
                '}';
    }
}
