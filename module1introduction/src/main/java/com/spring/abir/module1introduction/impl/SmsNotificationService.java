package com.spring.abir.module1introduction.impl;

import com.spring.abir.module1introduction.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("smsNotif")
public class SmsNotificationService implements NotificationService {

    @Override
    public void send(String message) {
        System.out.println("Sms Sending... " + message);
    }
}
