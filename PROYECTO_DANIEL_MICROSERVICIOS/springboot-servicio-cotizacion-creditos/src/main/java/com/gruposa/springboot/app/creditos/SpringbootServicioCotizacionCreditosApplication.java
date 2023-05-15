package com.gruposa.springboot.app.creditos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringbootServicioCotizacionCreditosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioCotizacionCreditosApplication.class, args);
	}

}
