package com.example.sicred;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SicredApplication {

	public static void main(String[] args) {
		SpringApplication.run(SicredApplication.class, args);
	}

}
