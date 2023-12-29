package com.example.spring.service;

import com.example.spring.dto.response.MajorsResponse;

import java.util.List;

public interface MajorsService {
    List<MajorsResponse> getAllMajors();
}
