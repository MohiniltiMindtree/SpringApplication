package com.example.DominosEurekaClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DominosEurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DominosEurekaClientApplication.class, args);
	}

}
