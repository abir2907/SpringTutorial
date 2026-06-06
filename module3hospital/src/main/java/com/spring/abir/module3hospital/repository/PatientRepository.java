package com.spring.abir.module3hospital.repository;

import com.spring.abir.module3hospital.IPatientInfo;
import com.spring.abir.module3hospital.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.util.pattern.PathPattern;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("select p.id as id, p.name as name, p.email as email from Patient p")
    List<IPatientInfo> getAllPatientsInfo();
}
