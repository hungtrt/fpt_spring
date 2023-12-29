package com.example.spring.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SchoolResponse {
    private String maTruong;
    private String tenTruong;
    private String diaChi;
    private String soDT;
}
