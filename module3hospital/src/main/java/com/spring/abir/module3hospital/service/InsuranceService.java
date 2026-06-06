package com.spring.abir.module3hospital.service;

import com.spring.abir.module3hospital.entity.Insurance;
import com.spring.abir.module3hospital.entity.Patient;
import com.spring.abir.module3hospital.repository.InsuranceRepository;
import com.spring.abir.module3hospital.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        // patient is in persistent stage, and it will get dirtied
        // because of which it will be synchronized
        // to synchronize the patient it will do setInsurance
        // but insurance is in transient state, therefore we use cascading
        // to convert insurance into persistent stage first
        // All this happens because of wrote @Transactional because of which
        // our connection to the db remained open and hibernate keeps
        // watching our patient entity and does dirty checking
        patient.setInsurance(insurance);

        // optional, done for consistency, this won't affect the database
        insurance.setPatient(patient);

        return insurance;
    }

}
