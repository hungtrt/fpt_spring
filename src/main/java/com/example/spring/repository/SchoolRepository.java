package com.example.spring.repository;

import com.example.spring.models.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<School, String> {

}
