package com.example.demotrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan( basePackages = {"com.example.*"})
public class DemoTradeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTradeApplication.class, args);
	}

}
