package com.riksonpereira.expensetracker;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "AcuBudget API Documentation",
                description = "The API is Documented to test and execute my knowledge in SpringBoot and documentation",
                version = "v1.0",
                contact = @Contact(
                        name = "Rikson",
                        email = "riksonpereira22@gmail.com",
                        url = "https://github.com/RiksonPereira"
                )
        ),
        externalDocs = @ExternalDocumentation(
            description = "AcuBudget API Documentation",
            url = "https://github.com/RiksonPereira/AcuBudget"
)
)
@SpringBootApplication
public class AcuBudgetApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcuBudgetApplication.class, args);
    }

}
