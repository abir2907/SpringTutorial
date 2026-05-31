package com.spring.abir.module2web.repositories;

import com.spring.abir.module2web.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
