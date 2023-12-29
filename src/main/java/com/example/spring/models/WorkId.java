package com.example.spring.models;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Data
public class WorkId implements Serializable {
    @Column(name = "so_cmnd")
    private String soCMND;

    @Column(name = "ngay_vao_cong_ty")
    private Date ngayVaoCongTy;
}
