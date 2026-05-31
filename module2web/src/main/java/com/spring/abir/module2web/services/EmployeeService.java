package com.spring.abir.module2web.services;

import com.spring.abir.module2web.dto.EmployeeDTO;
import com.spring.abir.module2web.entities.EmployeeEntity;
import com.spring.abir.module2web.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeDTO getEmployeeById(Long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElse(null);
        ModelMapper mapper = new ModelMapper();
        return mapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeEntity> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeEntity createNewEmployee(EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }
}
