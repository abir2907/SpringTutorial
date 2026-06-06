package com.spring.abir.module3hospital;

import com.spring.abir.module3hospital.entity.Insurance;
import com.spring.abir.module3hospital.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);
    }
}
