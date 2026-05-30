package com.spring.abir.module1introduction;

import com.spring.abir.module1introduction.impl.EmailNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Module1introductionApplication implements CommandLineRunner {

	@Autowired
	NotificationService notificationServiceObj;

	public static void main(String[] args) {
		SpringApplication.run(Module1introductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		notificationServiceObj.send("Hello");
	}
}
