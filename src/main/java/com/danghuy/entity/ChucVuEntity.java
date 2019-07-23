package com.danghuy.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "chucvu")
public class ChucVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChucVu;
    private String name;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "chucVuEntities")
    private List<NhanVienEntity> nhanVienEntities;
    public ChucVuEntity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<NhanVienEntity> getNhanVienEntities() {
        return nhanVienEntities;
    }

    public void setNhanVienEntities(List<NhanVienEntity> nhanVienEntities) {
        this.nhanVienEntities = nhanVienEntities;
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return name;
    }

    public void setTenChucVu(String name) {
        this.name = name;
    }
}
