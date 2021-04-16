package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com")
public class TradeRecommendationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradeRecommendationSystemApplication.class, args);
	}

}
