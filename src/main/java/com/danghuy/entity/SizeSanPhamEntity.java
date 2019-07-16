package com.danghuy.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sizesanpham")
public class SizeSanPhamEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSize;
    private String size;

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
