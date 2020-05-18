package com.amdocs.media;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer 
public class AssignmentNamingServerApplication {
	
	

	public static void main(String[] args) {
		SpringApplication.run(AssignmentNamingServerApplication.class, args);
	}

}
