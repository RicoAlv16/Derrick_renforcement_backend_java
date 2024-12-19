package com.derrick.demo.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class DemoGetwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoGetwayApplication.class, args);
	}

}
