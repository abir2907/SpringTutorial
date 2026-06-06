package com.spring.abir.module3hospital;

import com.spring.abir.module3hospital.entity.Appointment;
import com.spring.abir.module3hospital.entity.Insurance;
import com.spring.abir.module3hospital.service.AppointmentService;
import com.spring.abir.module3hospital.service.InsuranceService;
import com.spring.abir.module3hospital.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_23G")
                .validUntil(LocalDate.of(2030,1,1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createNewAppointment(appointment, 1L, 1L);
        System.out.println(updatedAppointment);
    }

}
