package com.danghuy.service;

import com.danghuy.entity.GopYEntity;

import java.util.List;

public interface GopYService {
    public void saveGopY(GopYEntity gopYEntity);

    public List<GopYEntity> getAllGopY();
}
