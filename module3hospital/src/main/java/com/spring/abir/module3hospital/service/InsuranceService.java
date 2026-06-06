package com.spring.abir.module3hospital.service;

import com.spring.abir.module3hospital.repository.InsuranceRepository;
import com.spring.abir.module3hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

}
