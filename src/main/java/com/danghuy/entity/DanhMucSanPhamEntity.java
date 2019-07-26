package com.danghuy.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "danhmucsanpham")
public class DanhMucSanPhamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDanhMuc;
    private String tenDanhMuc;
    private String hinhDanhMuc;

    @OneToMany()
    @JoinColumn(name = "idDanhMuc")
    Set<SanPhamEntity> sanPhamEntities;

    public Set<SanPhamEntity> getSanPhamEntities() {
        return sanPhamEntities;
    }

    public void setSanPhamEntities(Set<SanPhamEntity> sanPhamEntities) {
        this.sanPhamEntities = sanPhamEntities;
    }

    public int getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(int idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public String getHinhDanhMuc() {
        return hinhDanhMuc;
    }

    public void setHinhDanhMuc(String hinhDanhMuc) {
        this.hinhDanhMuc = hinhDanhMuc;
    }
}
