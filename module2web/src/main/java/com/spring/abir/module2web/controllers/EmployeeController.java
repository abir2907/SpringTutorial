package com.spring.abir.module2web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping(path = "/getSecretMessage")
    public String getSecretMessage() {
        return "Secret Msg: ABC";
    }
}
