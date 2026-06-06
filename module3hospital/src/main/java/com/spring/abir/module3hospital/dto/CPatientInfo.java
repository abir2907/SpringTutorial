package com.spring.abir.module3hospital.dto;

import lombok.Data;

@Data
public class CPatientInfo {

    private final Long id;
    private final String name;
    // By default, @Data creates a no args constructor
    // By writing final, it will instead create an args constructor for these fields

}
