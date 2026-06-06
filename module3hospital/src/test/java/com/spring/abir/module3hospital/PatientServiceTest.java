package com.spring.abir.module3hospital;

import com.spring.abir.module3hospital.entity.Patient;
import com.spring.abir.module3hospital.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient() {
        // List<Patient> patientList = patientRepository.findAll();
        List<IPatientInfo> patientList = patientRepository.getAllPatientsInfo();

        for(IPatientInfo p : patientList) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getEmail());
        }
    }

}
