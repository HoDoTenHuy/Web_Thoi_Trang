package com.danghuy.commons.conveter;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.entity.NhanVienEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.pojo.ChucVu;
import com.danghuy.pojo.NhanVien;
import com.danghuy.pojo.SanPham;
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
    public SanPham convertSanPham(SanPhamEntity sanPhamEntity){
        SanPham sanPham = new SanPham();
        sanPham.setIdSanPham(sanPhamEntity.getIdSanPham());
        sanPham.setTenSanPham(sanPhamEntity.getTenSanPham());
        sanPham.setChiTietSanPhams(sanPhamEntity.getChiTietSanPhamEntities());
        sanPham.setDanhMucSanPham(sanPhamEntity.getDanhMucSanPhamEntity());
        sanPham.setGianhCho(sanPhamEntity.getGianhCho());
        sanPham.setGiaTien(sanPhamEntity.getGiaTien());
        sanPham.setHinhSanPham(sanPhamEntity.getHinhSanPham());
        sanPham.setMoTa(sanPhamEntity.getMoTa());
        sanPham.setKhuyenMaiEntities(sanPhamEntity.getKhuyenMaiEntities());
        return sanPham;
    }
}
