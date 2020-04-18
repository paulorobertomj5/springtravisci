package br.com.spring.restspringboot;

import br.com.spring.restspringboot.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@SpringBootApplication
@ComponentScan(value = {"br.com.spring.restspringboot.api"} )
public class RestspringbootApplication {

//	@Autowired
//	private UserService userService;
//
//	@PostConstruct
//	public void loadUsers(){
//		userService.getUsers();
//	}

	public static void main(String[] args) {
		SpringApplication.run(RestspringbootApplication.class, args);
	}

}
