package com.danghuy.commons.conveter;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.ChucVu;
import com.danghuy.pojo.NhanVien;
import org.springframework.stereotype.Component;

@Component
public class PojoToEntity {
    public ChucVuEntity convertChucVu(ChucVu chucVu) {
        ChucVuEntity chucVuEntity = new ChucVuEntity();
        chucVuEntity.setIdChucVu(chucVu.getId());
        chucVu.setTenChucVu(chucVu.getTenChucVu());
        return chucVuEntity;
    }

    public NhanVienEntity convertNhanVien(NhanVien nhanVien) {
        NhanVienEntity nhanVienEntity = new NhanVienEntity();
        nhanVienEntity.setIdNhanVien(nhanVien.getIdNhanVien());
        nhanVienEntity.setCMND(nhanVien.getCMND());
        nhanVienEntity.setDiaChi(nhanVien.getDiaChi());
        nhanVienEntity.setEmail(nhanVien.getEmail());
        nhanVienEntity.setGioiTinh(nhanVien.getGioiTinh());
        nhanVienEntity.setHoTen(nhanVien.getHoTen());
        nhanVienEntity.setMatKhau(nhanVien.getMatKhau());
        nhanVienEntity.setTenDangNhap(nhanVien.getTenDangNhap());
        return nhanVienEntity;
    }
}
