package com.danghuy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDonEntity implements Serializable {

    @EmbeddedId
    ChiTietHoaDonIDEntity chiTietHoaDonIDEntity;
    private int soLuong;
    private String giaTien;


    public ChiTietHoaDonIDEntity getChiTietHoaDonIDEntity() {
        return chiTietHoaDonIDEntity;
    }

    public void setChiTietHoaDonIDEntity(ChiTietHoaDonIDEntity chiTietHoaDonIDEntity) {
        this.chiTietHoaDonIDEntity = chiTietHoaDonIDEntity;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(String giaTien) {
        this.giaTien = giaTien;
    }
}
