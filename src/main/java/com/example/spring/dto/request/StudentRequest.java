package com.example.spring.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
public class StudentRequest {
    @NotEmpty(message = "Số Chứng Minh Nhân Dân là bắt buộc")
    private String soCMND;
    private String hoTen;
    private String email;
    private String soDT;
    private String diaChi;

    @NotEmpty(message = "Mã Trường là bắt buộc")
    private String maTruong;

    @NotEmpty(message = "Mã Ngành là bắt buộc")
    private String maNganh;

    private String heTN;
    @NotNull(message = "Ngày TN là bắt buộc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayTN;
    private String loaiTN;

    public StudentRequest(String soCMND, String hoTen, String email, String soDT, String diaChi, String maTruong, String maNganh, String heTN, Date ngayTN, String loaiTN) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.diaChi = diaChi;
        this.maTruong = maTruong;
        this.maNganh = maNganh;
        this.heTN = heTN;
        this.ngayTN = ngayTN;
        this.loaiTN = loaiTN;
    }

    public StudentRequest() {
    }

}
