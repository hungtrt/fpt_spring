package com.example.spring.dto.response;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class MajorsResponse {
    private String maNganh;
    private String tenNganh;
    private String loaiNganh;
}
