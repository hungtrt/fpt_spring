package com.example.spring.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentWorkResponse {
    private String soCMND;
    private String hoTen;
    private String maNganh;
    private String maTruong;
    private String maNganhCongTy;
    private String tenCongTy;
    private String thoiGianLamViec;

    public StudentWorkResponse(String soCMND, String hoTen, String maNganh, String maTruong, String maNganhCongTy, String tenCongTy, String thoiGianLamViec) {
        this.soCMND = soCMND;
        this.hoTen = hoTen;
        this.maNganh = maNganh;
        this.maTruong = maTruong;
        this.maNganhCongTy = maNganhCongTy;
        this.tenCongTy = tenCongTy;
        this.thoiGianLamViec = thoiGianLamViec;
    }

    public StudentWorkResponse() {
    }
}
