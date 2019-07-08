package com.danghuy.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ChiTietHoaDonIDEntity implements Serializable {
    private int idHoaDon;
    private int idChiTietSanPham;

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getIdChiTietSanPham() {
        return idChiTietSanPham;
    }

    public void setIdChiTietSanPham(int idChiTietSanPham) {
        this.idChiTietSanPham = idChiTietSanPham;
    }
}
