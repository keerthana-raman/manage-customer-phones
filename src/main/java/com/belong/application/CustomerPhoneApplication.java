package com.belong.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = "com.belong.api,com.belong.service")
public class CustomerPhoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerPhoneApplication.class, args);
	}

}
