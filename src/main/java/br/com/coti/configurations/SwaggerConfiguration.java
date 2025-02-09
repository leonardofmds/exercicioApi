package br.com.coti.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	@Bean
	OpenAPI customOpenAPI() {
		return new OpenAPI().info(new Info().title("API de Contatos").description("API Spring Boot para controle de contatos").version("1.0")
				.contact(new Contact().name("Leonardo Menezes").email("leonardomenezes.dev@gmail.com")));
	}
}
