package com.spring.abir.module3hospital.repository;

import com.spring.abir.module3hospital.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}