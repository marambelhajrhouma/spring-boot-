package com.example.SpringMongoProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringMongoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoProjectApplication.class, args);
	}

}
