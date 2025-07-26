package com.laptoprental.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext cont=SpringApplication.run(BackendApplication.class, args);
	}

}
