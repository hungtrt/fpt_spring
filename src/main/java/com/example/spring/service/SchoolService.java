package com.example.spring.service;

import com.example.spring.dto.response.SchoolResponse;

import java.util.List;

public interface SchoolService {
    List<SchoolResponse> getAllSchools();
}
