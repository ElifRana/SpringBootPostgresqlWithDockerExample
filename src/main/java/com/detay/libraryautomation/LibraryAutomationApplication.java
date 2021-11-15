package com.detay.libraryautomation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class LibraryAutomationApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryAutomationApplication.class, args);
    }

}
