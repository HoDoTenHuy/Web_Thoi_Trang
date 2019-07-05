package com.danghuy.service;

import com.danghuy.commons.conveter.EntityToPojo;
import com.danghuy.dao.ChucVuDAO;
import com.danghuy.entity.ChucVuEntity;
import com.danghuy.pojo.ChucVu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChucVuService {
    @Autowired
    ChucVuDAO chucVuDAO;

    @Autowired
    EntityToPojo entityToPojo;

    public ChucVu getChucVuByID(Integer id){
        ChucVuEntity chucVuEntity = (ChucVuEntity) chucVuDAO.getTenChucVu(id);
        ChucVu chucVu = entityToPojo.convert(chucVuEntity);
        return chucVu;
    }
}