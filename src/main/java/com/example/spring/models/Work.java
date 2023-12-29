package com.example.spring.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cong_viec", schema = "fpt_2")
public class Work {
    @EmbeddedId
    private WorkId id;

    @JsonBackReference
    @ManyToOne
    private Majors nganh;

    @Column(name = "ten_cong_viec")
    private String tenCongViec;

    @Column(name = "ten_cong_ty")
    private String tenCongTy;


    @Column(name = "dia_chi_cong_ty")
    private String diaChiCongTy;

    @Column(name = "thoi_gian_lam_viec")
    private String thoiGianLamViec;
}
