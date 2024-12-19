package com.derrick.service_school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSchoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSchoolApplication.class, args);
	}

}
