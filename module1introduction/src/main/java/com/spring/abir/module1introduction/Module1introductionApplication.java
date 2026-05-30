package com.spring.abir.module1introduction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class Module1introductionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Module1introductionApplication.class, args);

		PaymentService paymentServiceObj = new PaymentService();
		paymentServiceObj.pay();
	}
}
