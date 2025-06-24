package com.edu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}) // 이렇게 해야 됨
public class Ex42SecuritySocialLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ex42SecuritySocialLoginApplication.class, args);
	}

}
