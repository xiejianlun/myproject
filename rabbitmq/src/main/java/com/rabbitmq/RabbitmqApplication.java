package com.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {

	//测试
	public static void main(String[] args) {
		System.out.print("---");
		SpringApplication.run(RabbitmqApplication.class, args);
	}

}
