package com.stackroute.designerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class DesignerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignerServiceApplication.class, args);
	}

}
