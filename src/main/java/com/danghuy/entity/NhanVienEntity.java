package com.danghuy.entity;

import org.omg.CORBA.PUBLIC_MEMBER;

public class NhanVienEntity{
    String tenNhanVien;
    String diaChi;
    int tuoi;

    public NhanVienEntity() {
    }
    public void getThongBao(){
        System.out.println("Hello, This is message of NhanVien!");
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
}
