package com.group4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class FreetutsApplication{

	public static void main(String[] args) {
		SpringApplication.run(FreetutsApplication.class, args);
	}
}
