package com.example.spring.service.impl;

import com.example.spring.dto.response.SchoolResponse;
import com.example.spring.models.School;
import com.example.spring.repository.SchoolRepository;
import com.example.spring.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService {
    private SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public List<SchoolResponse> getAllSchools() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList.stream().map(school -> mapToSchoolDto(school)).collect(Collectors.toList());
    }

    private SchoolResponse mapToSchoolDto(School school) {
        SchoolResponse schoolResponse = SchoolResponse.builder()
                .maTruong(school.getMaTruong())
                .tenTruong(school.getTenTruong())
                .diaChi(school.getDiaChi())
                .soDT(school.getSoDT())
                .build();
        return schoolResponse;
    }
}
