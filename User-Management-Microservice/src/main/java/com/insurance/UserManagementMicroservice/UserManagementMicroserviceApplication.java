package com.insurance.UserManagementMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class UserManagementMicroserviceApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(UserManagementMicroserviceApplication.class, args);
		System.out.println("This is a User Management Microservice.");
	}

	@Bean
	public RestTemplate restTemplate()
	{
		return new RestTemplate();
	}

}
