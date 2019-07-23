package com.danghuy.service.impl;

import com.danghuy.dao.ChucVuDAO;
import com.danghuy.entity.ChucVuEntity;
import com.danghuy.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChucVuServiceImpl implements ChucVuService {
    @Autowired
    ChucVuDAO chucVuDAO;
    public List<ChucVuEntity> chucVuEntities() {
        return chucVuDAO.chucVuEntities();
    }
}
