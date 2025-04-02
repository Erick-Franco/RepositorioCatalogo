package com.example.mscomprarserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MsComprarServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsComprarServerApplication.class, args);
	}

}
