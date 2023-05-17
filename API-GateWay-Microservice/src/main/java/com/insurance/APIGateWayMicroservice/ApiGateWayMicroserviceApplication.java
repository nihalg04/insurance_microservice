package com.insurance.APIGateWayMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ApiGateWayMicroserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ApiGateWayMicroserviceApplication.class, args);
		System.out.println("This is API-GATEWAY Microservice.");
	}

}
