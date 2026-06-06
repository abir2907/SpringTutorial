package com.spring.abir.module3hospital.repository;

import com.spring.abir.module3hospital.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}