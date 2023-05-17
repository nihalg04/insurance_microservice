package com.insurance.PolicyManagementMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PolicyManagementMicroserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(PolicyManagementMicroserviceApplication.class, args);
		System.out.println("This is a Policy Management Microservice.");
	}

}
