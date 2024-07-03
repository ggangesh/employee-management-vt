package com.codemind.whirlpool.employee_management.configuration;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPIConfig() {

		Server devServer = new Server();
		devServer.setUrl("https://dev-api-whirlpool/");
		devServer.setDescription("Dev server");
		
		Server localServer = new Server();
		localServer.setUrl("http://localhost:8081");
		localServer.setDescription("Dev server");

		
		Contact contact = new Contact();
		contact.setEmail("Praveen.bhosle5@gmail.com");
		contact.setName("Praveen Bhosle");
		contact.setUrl("https://www.whirlpoolindia.com/");

		Info info = new Info();
		info.setTitle("Whirlpool Employee Managment");
		info.setVersion("1.0.0");
		info.contact(contact);
		info.setDescription("This project is for whirlpool company employee managment");

		return new OpenAPI().info(info).servers(List.of(devServer,localServer));
	}

}
