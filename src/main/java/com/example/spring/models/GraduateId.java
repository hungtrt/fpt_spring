package com.example.spring.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
@Data
public class GraduateId implements Serializable {
    @Column(name = "so_cmnd")
    private String soCMND;

    @Column(name = "ma_truong")
    private String maTruong;

    @Column(name = "ma_nganh")
    private String maNganh;

    public GraduateId(String soCMND, String maTruong, String maNganh) {
        this.soCMND = soCMND;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
    }

    public GraduateId() {
    }
}
