package com.spring.abir.module4.clients.impl;

import com.spring.abir.module4.advice.ApiResponse;
import com.spring.abir.module4.clients.EmployeeClient;
import com.spring.abir.module4.dto.EmployeeDTO;
import com.spring.abir.module4.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeClientImpl implements EmployeeClient {

    private final RestClient restClient;

    Logger log = LoggerFactory.getLogger(EmployeeClientImpl.class);

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        log.info("Trying to retrieve all employees in getALlEmployees");
        try {
            log.debug("Attempting to call the restClient Method");
            ApiResponse<List<EmployeeDTO>> employeeDTOList = restClient
                    .get()
                    .uri("employees")
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("No employees present");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.info("Successfully retrieved the employees in getAllEmployees");
            return employeeDTOList.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
        log.trace("Trying to get Employee by Id in getEmployeeById with id: {}", employeeId);
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient
                    .get()
                    .uri("/employees/{employeeId}", employeeId)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not find the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            return employeeDTOApiResponse.getData();
        } catch (Exception e) {
            log.error("Exception occurred in getAllEmployees", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public EmployeeDTO createNewEmployee(EmployeeDTO employeeDTO) {
        log.trace("Trying to create Employee with information {}", employeeDTO);
        try {
            ApiResponse<EmployeeDTO> employeeDTOApiResponse = restClient
                    .post()
                    .uri("/employees")
                    .body(employeeDTO)
                    .retrieve()
                    .onStatus(HttpStatusCode::is4xxClientError, (req, res) -> {
                        log.debug("4xxClient error occurred during createNewEmployee");
                        log.error(new String(res.getBody().readAllBytes()));
                        throw new ResourceNotFoundException("Could not create the employee");
                    })
                    .body(new ParameterizedTypeReference<>() {
                    });
            log.trace("Successfully created a new employee: {}", employeeDTOApiResponse.getData());
            return employeeDTOApiResponse.getData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
