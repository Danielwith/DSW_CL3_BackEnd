package com.cibertec.cl3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class Cl3Application {

	public static void main(String[] args) {
		SpringApplication.run(Cl3Application.class, args);
	}

}
