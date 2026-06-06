package com.spring.abir.module3hospital.repository;

import com.spring.abir.module3hospital.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}