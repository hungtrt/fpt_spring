package com.example.spring.service;

import com.example.spring.dto.request.StudentRequest;
import com.example.spring.dto.response.StudentWorkResponse;
import com.example.spring.models.Student;

import java.util.List;

public interface StudentService {
    Student saveStudentForm(StudentRequest studentDto);
    List<Student> getAllStudents();

    List<StudentRequest> searchStudents(String query);

    List<StudentWorkResponse> getAllStudentWork();

    List<StudentWorkResponse> searchStudentWork(String query);
}
