package com.danghuy.commons.conveter;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.pojo.ChucVu;
import org.springframework.stereotype.Component;

@Component
public class PojoToEntity {
    public ChucVuEntity convert(ChucVu chucVu) {
        ChucVuEntity chucVuEntity = new ChucVuEntity();
        chucVuEntity.setIdChucVu(chucVu.getId());
        chucVu.setTenChucVu(chucVu.getTenChucVu());
        return chucVuEntity;
    }
}
