package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing //오디팅리스너를 쓰고 싶으면 선언해서 활성화 시켜야함
public class BootJpaBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJpaBasicApplication.class, args);
	}

}
