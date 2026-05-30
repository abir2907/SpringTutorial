package com.spring.abir.module1introduction;

import com.spring.abir.module1introduction.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1introductionApplication implements CommandLineRunner {

//	private final NotificationService notificationServiceObj;
//
//	public Module1introductionApplication(NotificationService notificationServiceObj) {
//		this.notificationServiceObj = notificationServiceObj; // Constructor Dependency Injection, the preferred way
//	}

	@Autowired
    Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1introductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// notificationServiceObj.send("Hello");

		for(var notificationService : notificationServiceMap.entrySet()) {
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}
	}
}
