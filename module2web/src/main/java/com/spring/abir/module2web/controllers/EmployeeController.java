package com.spring.abir.module2web.controllers;

import com.spring.abir.module2web.dto.EmployeeDTO;
import com.spring.abir.module2web.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeeById(
            @RequestBody EmployeeDTO employeeDTO,
            @PathVariable(name = "employeeId") Long id) {
        return employeeService.updateEmployeeById(id, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(
            @RequestBody Map<String, Object> updates,
            @PathVariable(name = "employeeId") Long id) {
        return employeeService.updatePartialEmployeeById(updates, id);
    }
}
