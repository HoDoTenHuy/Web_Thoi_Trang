package com.danghuy.pojo;

import com.danghuy.entity.NhanVienEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChucVu {
    private int id;
    private String tenChucVu;
    private List<NhanVienEntity> nhanVienEntities;

    public List<NhanVienEntity> getNhanVienEntities() {
        return nhanVienEntities;
    }

    public void setNhanVienEntities(List<NhanVienEntity> nhanVienEntities) {
        this.nhanVienEntities = nhanVienEntities;
    }

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
