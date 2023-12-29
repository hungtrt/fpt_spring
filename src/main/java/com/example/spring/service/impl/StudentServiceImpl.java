package com.example.spring.service.impl;

import com.example.spring.dto.request.StudentRequest;
import com.example.spring.dto.response.StudentWorkResponse;
import com.example.spring.models.Graduate;
import com.example.spring.models.GraduateId;
import com.example.spring.models.Student;
import com.example.spring.repository.GraduateRepository;
import com.example.spring.repository.StudentRepository;
import com.example.spring.service.StudentService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;
    private GraduateRepository graduateRepository;
    private final JdbcTemplate jdbcTemplate;

    public StudentServiceImpl(StudentRepository studentRepository, GraduateRepository graduateRepository, JdbcTemplate jdbcTemplate) {
        this.studentRepository = studentRepository;
        this.graduateRepository = graduateRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Student saveStudentForm(StudentRequest studentDto) {
        Student student = Student.builder()
                .soCMND(studentDto.getSoCMND())
                .hoTen(studentDto.getHoTen())
                .email(studentDto.getEmail())
                .soDT(studentDto.getSoDT())
                .diaChi(studentDto.getDiaChi())
                .build();
        studentRepository.save(student);

        Graduate graduate = Graduate.builder()
                .id(new GraduateId(studentDto.getSoCMND(), studentDto.getMaTruong(), studentDto.getMaNganh()))
                .heTN(studentDto.getHeTN())
                .ngayTN(studentDto.getNgayTN())
                .loaiTN(studentDto.getLoaiTN())
                .build();

        // Lưu Graduate
        graduateRepository.save(graduate);
        return student;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<StudentRequest> searchStudents(String query) {
        List<Student> students = studentRepository.searchStudents(query);
        return students.stream().map(student -> mapToStudentDto(student)).collect(Collectors.toList());
    }

    @Override
    public List<StudentWorkResponse> getAllStudentWork() {
        List<StudentWorkResponse> studentWorkDtoList = new ArrayList<>();
        List<Map<String, Object>> result = getAllStudentWorks();
        for (Map<String, Object> row : result) {
            StudentWorkResponse studentWorkDto = new StudentWorkResponse();
            studentWorkDto.setSoCMND((String) row.get("so_cmnd"));
            studentWorkDto.setHoTen((String) row.get("ho_ten"));
            studentWorkDto.setMaNganh((String) row.get("ma_nganh"));
            studentWorkDto.setMaTruong((String) row.get("ma_truong"));
            studentWorkDto.setMaNganhCongTy((String) row.get("ma_nganh_cong_viec"));
            studentWorkDto.setTenCongTy((String) row.get("ten_cong_ty"));
            studentWorkDto.setThoiGianLamViec((String) row.get("thoi_gian_lam_viec"));

            studentWorkDtoList.add(studentWorkDto);
        }

        return studentWorkDtoList;
    }

    @Override
    public List<StudentWorkResponse> searchStudentWork(String query) {
        List<StudentWorkResponse> studentWorkDtoList = new ArrayList<>();
        List<Map<String, Object>> result = findStudentWorks(query);

        for (Map<String, Object> row : result) {
            StudentWorkResponse studentWorkDto = new StudentWorkResponse();
            studentWorkDto.setSoCMND((String) row.get("so_cmnd"));
            studentWorkDto.setHoTen((String) row.get("ho_ten"));
            studentWorkDto.setMaNganh((String) row.get("ma_nganh"));
            studentWorkDto.setMaTruong((String) row.get("ma_truong"));
            studentWorkDto.setMaNganhCongTy((String) row.get("ma_nganh_cong_viec"));
            studentWorkDto.setTenCongTy((String) row.get("ten_cong_ty"));
            studentWorkDto.setThoiGianLamViec((String) row.get("thoi_gian_lam_viec"));

            studentWorkDtoList.add(studentWorkDto);
        }

        return studentWorkDtoList;
    }

    private List<Map<String, Object>> findStudentWorks(String query) {
        String sql = "SELECT sv.so_cmnd, sv.ho_ten, t.ma_nganh, t.ma_truong, cv.ma_nganh_cong_viec, cv.ten_cong_ty, cv.thoi_gian_lam_viec " +
                "FROM fpt_2.sinh_vien sv " +
                "JOIN fpt_2.tot_nghiep t ON t.so_cmnd = sv.so_cmnd " +
                "JOIN fpt_2.cong_viec cv ON t.so_cmnd = cv.so_cmnd " +
                "WHERE sv.so_cmnd LIKE CONCAT('%', ?, '%')";

        return jdbcTemplate.queryForList(sql, query);
    }

    public List<Map<String, Object>> getAllStudentWorks() {
        String sql = "SELECT sv.so_cmnd, sv.ho_ten, t.ma_nganh, t.ma_truong, cv.ma_nganh_cong_viec, cv.ten_cong_ty, cv.thoi_gian_lam_viec " +
                "FROM fpt_2.sinh_vien sv " +
                "JOIN fpt_2.tot_nghiep t ON t.so_cmnd = sv.so_cmnd " +
                "JOIN fpt_2.cong_viec cv ON t.so_cmnd = cv.so_cmnd";

        return jdbcTemplate.queryForList(sql);
    }


    private StudentRequest mapToStudentDto(Student student) {
        StudentRequest studentDto = StudentRequest.builder()
                .soCMND(student.getSoCMND())
                .hoTen(student.getHoTen())
                .email(student.getEmail())
                .soDT(student.getSoDT())
                .diaChi(student.getDiaChi())
                .build();
        return studentDto;
    }

    private Student mapToStudent(StudentRequest studentDto) {
        Student student = Student.builder()
                .soCMND(studentDto.getSoCMND())
                .hoTen(studentDto.getHoTen())
                .email(studentDto.getEmail())
                .soDT(studentDto.getSoDT())
                .diaChi(studentDto.getDiaChi())
                .build();
        return student;
    }
}
