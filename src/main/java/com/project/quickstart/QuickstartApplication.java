package com.project.quickstart;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class QuickstartApplication {
	public static void main(String[] args) {
		System.out.println("Hello World");
		SpringApplication.run(QuickstartApplication.class, args);
	}

}
