package com.danghuy.entity;

import org.omg.CORBA.PUBLIC_MEMBER;

public class NhanVienEntity {
    String tenNhanVien;
    String diaChi;
    int tuoi;

    public NhanVienEntity() {
    }
    public NhanVienEntity createNhanVien(){
        NhanVienEntity nhanVienEntity = new NhanVienEntity();
        nhanVienEntity.setTenNhanVien("HuyKZ");
        return nhanVienEntity;
    }
    public void getThongBao() {
        System.out.println("Hello,My name is " + tenNhanVien);
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
