package com.spring.abir.module2web.controllers;

import com.spring.abir.module2web.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId) {
        return new EmployeeDTO(employeeId, "Abir", "abir@gmail.com", 23, LocalDate.of(2026, 3, 1), true);
    }

    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi age " + age + ", sort by: " + sortBy;
    }

}
