package com.spring.abir.module2web.controllers;

import com.spring.abir.module2web.dto.EmployeeDTO;
import com.spring.abir.module2web.entities.EmployeeEntity;
import com.spring.abir.module2web.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hi age " + age + ", sort by: " + sortBy;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        inputEmployee.setId(100L);
        return inputEmployee;
    }

    @PutMapping
    public String updateEmployeeById() {
        return "Employee Updated: PUT";
    }
}
