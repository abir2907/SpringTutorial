package com.spring.abir.module3hospital.service;

import com.spring.abir.module3hospital.entity.Appointment;
import com.spring.abir.module3hospital.entity.Doctor;
import com.spring.abir.module3hospital.entity.Patient;
import com.spring.abir.module3hospital.repository.AppointmentRepository;
import com.spring.abir.module3hospital.repository.DoctorRepository;
import com.spring.abir.module3hospital.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public Appointment createNewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }

}
