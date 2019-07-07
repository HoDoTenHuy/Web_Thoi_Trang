package com.danghuy.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "chucvu")
public class ChucVuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idChucVu;
    private String tenChucVu;
    @OneToMany(cascade = CascadeType.ALL)
            @JoinColumn(name = "idChucVu")
    Set<NhanVienEntity> nhanVienEntities;

    public ChucVuEntity(int idChucVu, String tenChucVu) {
        this.idChucVu = idChucVu;
        this.tenChucVu = tenChucVu;
    }

    public ChucVuEntity() {
    }

    public Set<NhanVienEntity> getNhanVienEntities() {
        return nhanVienEntities;
    }

    public void setNhanVienEntities(Set<NhanVienEntity> nhanVienEntities) {
        this.nhanVienEntities = nhanVienEntities;
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
