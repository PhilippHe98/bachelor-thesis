package com.example.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		System.out.println("Available Processors: " + Runtime.getRuntime().availableProcessors());
		System.out.println("Max Memory: " + Runtime.getRuntime().maxMemory());
		SpringApplication.run(Application.class, args);
	}
}
