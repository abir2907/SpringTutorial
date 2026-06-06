package com.spring.abir.module3hospital.service;

import com.spring.abir.module3hospital.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

}
