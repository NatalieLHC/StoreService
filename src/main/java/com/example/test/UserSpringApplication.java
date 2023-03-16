package com.example.test;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@OpenAPIDefinition(
        info = @Info(
                title = "Store Api",
                version = "v1.0.0",
                description = "store management api"
        )

)
@SpringBootApplication
@EnableConfigurationProperties
public class UserSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserSpringApplication.class, args);

    }

}
