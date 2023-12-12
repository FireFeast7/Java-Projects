package com.project.quickstart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
@Configuration
@ConfigurationProperties( prefix = "pizza")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PizzaConfig {
    String crust ;
    String cheese ;
    String toppings;
}
