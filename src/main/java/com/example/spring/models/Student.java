package com.example.spring.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "sinh_vien", schema = "fpt_2")
public class Student {
    @Id
    @Column(name = "so_cmnd")
    private String soCMND;

    @Column(name = "ho_ten")
    private String hoTen;

    @Column(name = "email")
    private String email;

    @Column(name = "so_dt")
    private String soDT;

    @Column(name = "dia_chi")
    private String diaChi;
}
