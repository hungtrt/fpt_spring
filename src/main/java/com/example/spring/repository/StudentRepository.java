package com.example.spring.repository;

import com.example.spring.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {
    @Query("SELECT s from Student s WHERE s.soCMND LIKE CONCAT('%', :query, '%')")
    List<Student> searchStudents(String query);
}
