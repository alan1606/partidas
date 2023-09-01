package com.diagnocons.partidas.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaPartidasApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaPartidasApplication.class, args);
	}

}
