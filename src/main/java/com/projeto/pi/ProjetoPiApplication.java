package com.projeto.pi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.projeto.pi.repository")
public class ProjetoPiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoPiApplication.class, args);
	}

}
