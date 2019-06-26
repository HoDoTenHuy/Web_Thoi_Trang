package com.danghuy.entity;

import java.util.List;
import java.util.Map;

public class NhanVienEntity {
    String tenNhanVien;
    String diaChi;
    int tuoi;
    GiamDocEntity giamDocEntity;
    List<GiamDocEntity> list;
    Map<String, Object> map;
    public NhanVienEntity() {
    }

    public NhanVienEntity(String tenNhanVien, int tuoi) {
        this.tenNhanVien = tenNhanVien;
        this.tuoi = tuoi;
    }

    public NhanVienEntity(String tenNhanVien, String diaChi, int tuoi) {
        this.tenNhanVien = tenNhanVien;
        this.diaChi = diaChi;
        this.tuoi = tuoi;
    }

    public NhanVienEntity(GiamDocEntity giamDocEntity) {
        this.giamDocEntity = giamDocEntity;
    }

    public void getThongBao() {
        System.out.println("Result : " + getGiamDocEntity().toString());
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public List<GiamDocEntity> getList() {
        return list;
    }

    public void setList(List<GiamDocEntity> list) {
        this.list = list;
    }

    public GiamDocEntity getGiamDocEntity() {
        return giamDocEntity;
    }

    public void setGiamDocEntity(GiamDocEntity giamDocEntity) {
        this.giamDocEntity = giamDocEntity;
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
