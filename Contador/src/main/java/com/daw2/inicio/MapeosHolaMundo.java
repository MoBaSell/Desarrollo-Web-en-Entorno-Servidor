package com.daw2.inicio;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapeosHolaMundo {
	static AtomicInteger visitas= new AtomicInteger(0); //para contar visitas

	public static void main(String[] args) {
		SpringApplication.run(ContadorApplication.class, args);
	}

	//@GetMapping("/hola") //Esto es lo que se va a poner en la busqueda / recibe solo get
	@RequestMapping("/hola") //recibe tanto get como post
	//@PostMapping("/hola") //recibe solo post
	@ResponseBody //Para que se envie un cuerpo
	
	public String HolaMundo(@RequestParam(name="nombre", required=false,defaultValue="Mundo") String nombre) { //para mostrar las variables
		/*
		if(nombre==null || nombre.isBlank()) {
			return "Hola mundo"; //Lo que se muestra en la web / si sepone "index.html" se ejecuta la pagina estatica			
		}*/
		//else 
		return "Hola "+nombre + " Visitas: "+visitas.getAndIncrement(); // getAndIncrement para obtener y incrementar
	}
}
 