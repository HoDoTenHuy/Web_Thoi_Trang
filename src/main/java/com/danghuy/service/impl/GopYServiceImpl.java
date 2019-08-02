package com.danghuy.service.impl;

import com.danghuy.dao.GopYDAO;
import com.danghuy.entity.GopYEntity;
import com.danghuy.service.GopYService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GopYServiceImpl implements GopYService {
    @Autowired
    GopYDAO gopYDAO;
    @Override
    public void saveGopY(GopYEntity gopYEntity) {
        gopYDAO.saveGopY(gopYEntity);
    }

    @Override
    public List<GopYEntity> getAllGopY() {
        return gopYDAO.getAllGopY();
    }
}
