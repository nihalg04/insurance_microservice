package com.insurance.UserManagementMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementMicroserviceApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(UserManagementMicroserviceApplication.class, args);
		System.out.println("This is a User Management Microservice.");
	}

}
