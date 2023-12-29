package com.example.spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tot_nghiep", schema = "fpt_2")
public class Graduate {
    @EmbeddedId
    private GraduateId id;

    @Column(name = "he_tn")
    private String heTN;

    @Column(name = "ngay_tn")
    private Date ngayTN;

    @Column(name = "loai_tn")
    private String loaiTN;
}
