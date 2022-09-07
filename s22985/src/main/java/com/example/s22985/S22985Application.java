package com.example.s22985;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// GRUPA B
@SpringBootApplication
public class S22985Application {
@Bean

	public RestTemplate restTemplate() {
	return new RestTemplate();
}
	public static void main(String[] args) {
		SpringApplication.run(S22985Application.class, args);
	}

}
