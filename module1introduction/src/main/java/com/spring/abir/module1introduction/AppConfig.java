package com.spring.abir.module1introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean
    PaymentService paymentService() {
        // more custom logic
        return new PaymentService();
    }
}
