package com.danghuy.entity;

public class GiamDocEntity extends NhanVienEntity {
    String chucVu;

    public GiamDocEntity(String chucVu, int tuoi, String tenNhanVien, String diaChi) {
        super(tenNhanVien, diaChi, tuoi);
        this.chucVu = chucVu;
    }

    public GiamDocEntity() {

    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "chucVu : " + chucVu + '\'' +
                ", tenNhanVien : '" + tenNhanVien + '\'' +
                ", diaChi : '" + diaChi + '\'' +
                ", tuoi : " + tuoi;
    }
}
