package com.danghuy.pojo;

import org.springframework.stereotype.Component;

@Component
public class ChucVu {
    private int id;
    private String tenChucVu;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public ChucVu() {
    }

    public ChucVu(int id, String tenChucVu) {
        this.id = id;
        this.tenChucVu = tenChucVu;
    }
}
