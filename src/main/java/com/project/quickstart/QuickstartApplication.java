package com.project.quickstart;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class QuickstartApplication implements CommandLineRunner {
	private PizzaConfig pizzaConfig;
	QuickstartApplication(PizzaConfig pizzaConfig){
		this.pizzaConfig = pizzaConfig;
	}

	public static void main(String[] args) {
		SpringApplication.run(QuickstartApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info(pizzaConfig.toString());
	}
}
