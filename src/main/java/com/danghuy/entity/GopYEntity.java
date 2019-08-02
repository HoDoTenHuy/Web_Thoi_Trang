package com.danghuy.entity;

import javax.persistence.*;

@Entity
@Table(name = "gopy")
public class GopYEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGopY;
    private String email;
    private String noiDung;

    public GopYEntity() {
    }

    public int getIdGopY() {
        return idGopY;
    }

    public void setIdGopY(int idGopY) {
        this.idGopY = idGopY;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
