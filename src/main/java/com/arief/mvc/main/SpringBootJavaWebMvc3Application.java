package com.arief.mvc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.arief.mvc")
public class SpringBootJavaWebMvc3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJavaWebMvc3Application.class, args);
	}
}
