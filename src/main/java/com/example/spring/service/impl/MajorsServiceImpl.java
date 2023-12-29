package com.example.spring.service.impl;

import com.example.spring.dto.response.MajorsResponse;
import com.example.spring.models.Majors;
import com.example.spring.repository.MajorsRepository;
import com.example.spring.service.MajorsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MajorsServiceImpl implements MajorsService {
    private MajorsRepository majorsRepository;

    public MajorsServiceImpl(MajorsRepository majorsRepository) {
        this.majorsRepository = majorsRepository;
    }

    @Override
    public List<MajorsResponse> getAllMajors() {
        List<Majors> majorsList = majorsRepository.findAll();
        return majorsList.stream().map((majors) -> mapToMajorsDto(majors)).collect(Collectors.toList());
    }

    private MajorsResponse mapToMajorsDto(Majors majors) {
        MajorsResponse majorsDto = MajorsResponse.builder()
                .maNganh(majors.getMaNganh())
                .tenNganh(majors.getTenNganh())
                .loaiNganh(majors.getLoaiNganh())
                .build();
        return majorsDto;
    }

}
