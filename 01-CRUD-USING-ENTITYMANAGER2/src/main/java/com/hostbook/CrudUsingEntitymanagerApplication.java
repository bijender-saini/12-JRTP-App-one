package com.hostbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CrudUsingEntitymanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsingEntitymanagerApplication.class, args);
	}

}
