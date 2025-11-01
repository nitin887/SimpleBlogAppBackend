package com.simpleblogappbackend.simpleblogappbackend;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Simple Blog App Backend",
				version = "1.0",
				description = "This is a simple blog application backend."
		)
)
public class SimpleBlogAppBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBlogAppBackendApplication.class, args);
	}

}
