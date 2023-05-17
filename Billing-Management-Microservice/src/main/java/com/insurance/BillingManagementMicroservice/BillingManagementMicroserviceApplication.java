package com.insurance.BillingManagementMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BillingManagementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingManagementMicroserviceApplication.class, args);
		System.out.println("This is a Billing Management Microservice.");
	}

}
