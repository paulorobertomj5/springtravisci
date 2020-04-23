package br.com.spring.restspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan(value = {"br.com.spring.restspringboot.api"} )
public class RestspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestspringbootApplication.class, args);
	}

}
