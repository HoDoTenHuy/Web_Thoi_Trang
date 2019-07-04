package com.danghuy.commons.conveter;

import com.danghuy.entity.ChucVuEntity;
import com.danghuy.pojo.ChucVu;
import org.springframework.stereotype.Component;

@Component
public class EntityToPojo {
    public ChucVu convert(ChucVuEntity chucVuEntity){
        ChucVu chucVu = new ChucVu();
        chucVu.setId(chucVuEntity.getIdChucVu());
        chucVu.setTenChucVu(chucVuEntity.getTenChucVu());
        return chucVu;
    }
}
