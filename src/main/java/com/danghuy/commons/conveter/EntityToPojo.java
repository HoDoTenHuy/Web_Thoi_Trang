package com.danghuy.commons.conveter;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.pojo.ChucVu;
import com.danghuy.pojo.NhanVien;
import org.springframework.stereotype.Component;

@Component
public class EntityToPojo {
    public ChucVu convertChucVu(ChucVuEntity chucVuEntity) {
        ChucVu chucVu = new ChucVu();
        chucVu.setId(chucVuEntity.getIdChucVu());
        chucVu.setTenChucVu(chucVuEntity.getTenChucVu());
        return chucVu;
    }

    public NhanVien convertNhanVien(NhanVienEntity nhanVienEntity) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setIdNhanVien(nhanVienEntity.getIdNhanVien());
        nhanVien.setCMND(nhanVienEntity.getCMND());
        nhanVien.setDiaChi(nhanVienEntity.getDiaChi());
        nhanVien.setEmail(nhanVienEntity.getEmail());
        nhanVien.setGioiTinh(nhanVienEntity.getGioiTinh());
        nhanVien.setHoTen(nhanVienEntity.getHoTen());
        nhanVien.setMatKhau(nhanVienEntity.getMatKhau());
        nhanVien.setTenDangNhap(nhanVienEntity.getTenDangNhap());
        return nhanVien;
    }
}
