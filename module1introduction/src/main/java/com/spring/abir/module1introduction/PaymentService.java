package com.spring.abir.module1introduction;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay() {
        System.out.println("Paying...");
    }

    @PostConstruct
    public void afterInit() {
        System.out.println("Before Payment");
    }

    @PreDestroy
    public void beforeDel() {
        System.out.println("After Payment");
    }
}
