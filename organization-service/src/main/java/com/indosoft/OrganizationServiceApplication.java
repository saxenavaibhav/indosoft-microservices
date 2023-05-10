package com.indosoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "Organization Service REST API",
			description = "Organization Service REST API documetation",
			version = "v1.0",
			contact = @Contact(
					name = "Vaibhav Saxena",
					email = "reachvabhavsaxena@gmail.com"
			),
			license = @License(
					name = "Apache 2.0"
			)
		  )
		)
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrganizationServiceApplication.class, args);
	}

}
