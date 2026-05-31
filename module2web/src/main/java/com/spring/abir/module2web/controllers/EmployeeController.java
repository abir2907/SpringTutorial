package com.spring.abir.module2web.controllers;

import com.spring.abir.module2web.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {

    @GetMapping(path = "/employees/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "Abir", "abir@gmail.com", 23, LocalDate.of(2026, 3, 1), true);
    }

}
