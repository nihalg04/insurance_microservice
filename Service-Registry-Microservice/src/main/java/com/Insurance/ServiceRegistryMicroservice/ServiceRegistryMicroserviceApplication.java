package com.Insurance.ServiceRegistryMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistryMicroserviceApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(ServiceRegistryMicroserviceApplication.class, args);
		System.out.println("This is a Service Registry Microservice.");
	}

}
