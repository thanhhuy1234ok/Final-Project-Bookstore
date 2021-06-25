package com.bookstore.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan({"com.bookstore.model"})
public class BookStoreAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreAdminApplication.class, args);
	}

}
