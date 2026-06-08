package com.spring.abir.module4.clients;

import com.spring.abir.module4.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeClient {
    List<EmployeeDTO> getAllEmployees();
}
