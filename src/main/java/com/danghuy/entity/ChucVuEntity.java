package com.danghuy.entity;
import javax.persistence.*;

@Entity
@Table(name = "chucvu")
public class ChucVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChucVu;
    private String tenChucVu;

    public ChucVuEntity(int idChucVu, String tenChucVu) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
    }

    public ChucVuEntity() {
    }

    public int getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(int idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }
}
