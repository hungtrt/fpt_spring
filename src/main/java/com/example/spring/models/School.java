package com.example.spring.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "truong", schema = "fpt_2")
public class School {
    @Id
    @Column(name = "ma_truong")
    private String maTruong;

    @Column(name = "ten_truong")
    private String tenTruong;

    @Column(name = "dia_chi")
    private String diaChi;

    @Column(name = "so_dt")
    private String soDT;
}
