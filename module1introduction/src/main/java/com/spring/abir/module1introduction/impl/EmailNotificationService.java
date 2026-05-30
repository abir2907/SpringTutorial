package com.spring.abir.module1introduction.impl;

import com.spring.abir.module1introduction.NotificationService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Email sending... " + message);
    }
}
