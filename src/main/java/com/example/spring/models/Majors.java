package com.example.spring.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nganh", schema = "fpt_2")
public class Majors {
    @Id
    @Column(name = "ma_nganh")
    private String maNganh;

    @Column(name = "ten_nganh")
    private String tenNganh;

    @Column(name = "loai_nganh")
    private String loaiNganh;

    @JsonManagedReference
    @OneToMany(mappedBy = "nganh")
    private List<Work> works;
}
