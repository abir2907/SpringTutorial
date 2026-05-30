package com.spring.abir.module1introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class AppConfig {

    @Bean
    @Scope("prototype")
    PaymentService paymentService() {
        // more custom logic
        return new PaymentService();
    }
}
