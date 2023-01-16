package com.example.testApp.repository;

import com.example.testApp.models.Specilization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecRepo extends JpaRepository<Specilization,Long> {
}
