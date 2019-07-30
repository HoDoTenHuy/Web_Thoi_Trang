package com.danghuy.commons;

import com.danghuy.entity.KhuyenMaiEntity;
import com.danghuy.entity.SanPhamEntity;
import com.danghuy.service.impl.KhuyenMaiServiceImpl;
import com.danghuy.service.impl.SanPhamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

@Component
public class CheckGiamGia {
    @Autowired
    KhuyenMaiServiceImpl khuyenMaiService;

    public void giaKhyenMai(SanPhamEntity sanPhamEntity, int idSanPham, ModelMap modelMap){
        List<KhuyenMaiEntity> khuyenMaiEntities = khuyenMaiService.getAllKhuyenMai();
        KhuyenMaiEntity khuyenMaiEntity = new KhuyenMaiEntity();
        for(KhuyenMaiEntity value : khuyenMaiEntities){
            for(SanPhamEntity id : value.getSanPhamEntities()){
                if(id.getIdSanPham() == idSanPham){
                    khuyenMaiEntity = value;
                }
            }
        }
        int giamGia = khuyenMaiEntity.getGiamGia();

        String giaCu = sanPhamEntity.getGiaTien();
        CharSequence s1 = ".";
        CharSequence s2 = "";
        String gia = giaCu.replace(s1, s2);
        int giaTien = Integer.parseInt(gia);
        int giaKhuyenMai = giaTien - giaTien*giamGia/100;

        Locale locale = new Locale("vi", "VN");
        Currency currency = Currency.getInstance("VND");

        DecimalFormatSymbols df = DecimalFormatSymbols.getInstance(locale);
        df.setCurrency(currency);
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        numberFormat.setCurrency(currency);
        String formatKhuyenMai = numberFormat.format(giaKhuyenMai);

        modelMap.addAttribute("giaKhuyenMai", formatKhuyenMai);
        modelMap.addAttribute("giamgia", giamGia);
    }
}
