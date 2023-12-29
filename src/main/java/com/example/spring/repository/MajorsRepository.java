package com.example.spring.repository;

import com.example.spring.models.Majors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MajorsRepository extends JpaRepository<Majors, String> {
}
