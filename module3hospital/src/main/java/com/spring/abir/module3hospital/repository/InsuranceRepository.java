package com.spring.abir.module3hospital.repository;

import com.spring.abir.module3hospital.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}