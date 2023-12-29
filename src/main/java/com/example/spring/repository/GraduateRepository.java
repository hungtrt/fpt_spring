package com.example.spring.repository;

import com.example.spring.models.Graduate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GraduateRepository extends JpaRepository<Graduate, String> {
}
