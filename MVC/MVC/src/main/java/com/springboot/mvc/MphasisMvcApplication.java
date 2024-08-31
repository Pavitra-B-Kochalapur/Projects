package com.springboot.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MphasisMvcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ac = SpringApplication.run(MphasisMvcApplication.class, args);
		ac.start();
		
	}

}
