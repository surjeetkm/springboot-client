package com.c2p.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@Configuration
public class ASpringbootMysqlClientApplication {

	private static final String URL="http://springboot-k8s-mysql:8080/users";
	@Autowired
	private RestTemplate restTemplate;
	public static void main(String[] args) {
		SpringApplication.run(ASpringbootMysqlClientApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@RequestMapping(value = "/getmessage",method = RequestMethod.GET)
	public String getResources() {
		ResponseEntity<String> res=restTemplate.getForEntity(URL, String.class);
		return res.getBody();
	}
}
