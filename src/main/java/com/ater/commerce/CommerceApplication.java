package com.ater.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages = {"com.ater.commerce.user"})
public class CommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommerceApplication.class,args);
	}

}
