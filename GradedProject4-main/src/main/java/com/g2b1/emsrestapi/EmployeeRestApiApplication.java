package com.g2b1.emsrestapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Spring-Boot Application starts here!
@SpringBootApplication
public class EmployeeRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
		System.out.println("\nEmployee Management REST API at work ...");
		System.out.println("\nGo to Postman and hit the appropriate URLs ...\n");
	}

}