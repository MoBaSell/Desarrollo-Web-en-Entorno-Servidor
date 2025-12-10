package com.example.demo.controllers;

import com.example.demo.services.ServicioAlmacen;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ControladorTienda {

    ServicioAlmacen servicioAlmacen;
	
	public ControladorTienda(ServicioAlmacen servicioAlmacen) {
		this.servicioAlmacen = servicioAlmacen;
	}
	
	@GetMapping("/")
	public String muestraFormularioTienda(Model modelo) {
		modelo.addAttribute("finalCompra",false);
		modelo.addAttribute("almacen",servicioAlmacen.getAll());
		return "carrito";
	}
	
	@PostMapping("/")
	public String procesaFromularioTienda(Model modelo,
			@RequestParam Map<String,String> camposForm) {
		
		camposForm.remove("comprar");
		servicioAlmacen.restaStock(camposForm);
		modelo.addAttribute("almacen",servicioAlmacen.getAll());
		return "carrito";
	}
}
