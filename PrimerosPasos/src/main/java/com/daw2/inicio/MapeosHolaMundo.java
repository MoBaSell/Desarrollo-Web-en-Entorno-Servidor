package com.daw2.inicio;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MapeosHolaMundo {

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
		return "Hola "+nombre;
	}
}
 