package com.team4;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@SpringBootApplication
@ComponentScan(basePackages = "com.team4.")
@EntityScan("com.team4.")
@EnableJpaRepositories(basePackages = "com.team4.repositories")
public class BoardGameProjectApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BoardGameProjectApplication.class, args);
	}

}