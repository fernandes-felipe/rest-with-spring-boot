package br.com.erudio.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiIConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("RESTful api Java and Spring Boot")	
					.version(null)
					.description("Person API")
					.termsOfService("")
					.license(
							new License()
								.name("Apache 2.0")
								.url("https://www.linkedin.com/in/felipe-fernandes-81925b150/")));
	}
}
