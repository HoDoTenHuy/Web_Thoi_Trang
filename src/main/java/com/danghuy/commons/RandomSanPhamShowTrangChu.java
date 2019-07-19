package com.danghuy.commons;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.Vector;

@Component
public class RandomSanPhamShowTrangChu {
    public Vector vectorSanPham(int maxSanPham){
        Vector v = new Vector();
        Random rd = new Random();
        int iNew = 0;
        for (int i = 1; i <= 20;  ) {
            iNew =1 + rd.nextInt(maxSanPham);
            if (!v.contains(iNew)){
                i++;
                v.add(iNew);
            }
        }
        return v;
    }
}
