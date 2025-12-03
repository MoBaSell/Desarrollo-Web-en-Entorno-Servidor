package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IniciarBD {

	@Bean
	CommandLineRunner iniciar(repositorioProducto repo) {
		
		return args ->{
			repo.save(new Producto("p1","Camiseta",15,10));
			repo.save(new Producto("p2","Gorra",25,7));
			repo.save(new Producto("p3","Zapatillas",12,110));
			repo.save(new Producto("p4","Abrigo",7,95));
			
		};
		
	}
	
	
}
