package com.spring.abir.module2web.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeRoleValidator implements ConstraintValidator<EmployeeRoleValidation, String> {

    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext context) {
        List<String> roles = List.of("USER", "ADMIN");
        return roles.contains(inputRole);
    }
}
