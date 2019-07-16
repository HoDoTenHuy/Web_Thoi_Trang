package com.danghuy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "mausanpham")
public class MauSanPhamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMau;
    private String tenMau;

    public int getIdMau() {
        return idMau;
    }

    public void setIdMau(int idMau) {
        this.idMau = idMau;
    }

    public String getTenMau() {
        return tenMau;
    }

    public void setTenMau(String tenMau) {
        this.tenMau = tenMau;
    }

    @Override
    public String toString() {
        return "tenMau :" + tenMau;
    }
}
