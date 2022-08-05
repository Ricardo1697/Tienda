package com.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "src")
@ComponentScan({"com.commons"})
@EntityScan("com.tienda.entity")
@EnableJpaRepositories("com.repository.PersonaRepository")
public class TiendaApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(TiendaApplication.class, args);
	}

}
