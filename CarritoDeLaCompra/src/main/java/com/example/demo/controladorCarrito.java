package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class controladorCarrito {
	
	private repositorioStock repositorio= new repositorioStock();
	private Map<String, Integer> carrito =new HashMap<>();
	
	@GetMapping("/")
	public String mostrarInicio(Model model,HttpSession sesion) {
		
		model.addAttribute("productos",repositorio.getProductos());
		model.addAttribute("carrito",carrito);
		
		double total = 0;
		for(String nombre:carrito.keySet()) {
			Producto p= repositorio.getProducto(nombre);
			if(p!=null) {
				total+=carrito.get(nombre) * p.getPrecio();
			}
		}
		model.addAttribute("total",total);
		
		String usuario=(String) sesion.getAttribute("usuario");
		model.addAttribute("usuario", usuario);
		
		return "productos";
	}
	
	@GetMapping("/bienvenida")
	public String bienvenidaForm() {
		return "bienvenida";
	}
	
	@PostMapping("/bienvenida")
	public String guardarDatos(@RequestParam("nombre") String nombre,
								Model model, 
								HttpSession sesion) {
		sesion.setAttribute("usuario", nombre);
		return "redirect:/";
		
	}
	
	
	@PostMapping("/aniadir")
	public String aniadir(@RequestParam("nombre") String nombre, @RequestParam("cantidad") int cantidad) {
		
		Producto p=repositorio.getProducto(nombre);
		
		if(p==null) {
			return "redirect:/";
		}
		
		if(cantidad > p.getStock()) {
			cantidad=p.getStock();
		}
		
		carrito.put(nombre, cantidad);
		return "redirect:/";
		
	}
	
	@GetMapping("/reponer")
	public String mostrarReponer(Model model) {
		model.addAttribute("productos", repositorio.getProductos());
		return "reponer";
	}
	
	@PostMapping("/reponer")
	public String actualizarStock(@RequestParam Map<String,String> datos, Model model) {
		
		for(Producto p: repositorio.getProductos()) {
			String datosNombre="stock_"+p.getNombre();
			if(datos.containsKey(datosNombre)) {
				try {
					int nuevoStock=Integer.parseInt(datos.get(datosNombre));
					if(nuevoStock < 0) {
						nuevoStock =0;
					}
					p.setStock(nuevoStock);
				}catch (Exception e) {
					
				}
			}
		}
		
		model.addAttribute("productos", repositorio.getProductos());
		model.addAttribute("mensaje", "Stock actualizado correctamnente");
		return "reponer";
	}
	
	
	@PostMapping("/finalizar")
	public String finalizar(Model model) {
		
		for(String nombre: carrito.keySet()) {
			Producto p=repositorio.getProducto(nombre);
			int cant=carrito.get(nombre);
			
			if(cant>p.getStock()) {
				model.addAttribute("mensaje","No hay stock suficiente de "+nombre);
				model.addAttribute("productos", repositorio.getProductos());
				model.addAttribute("carrito", carrito);
				return "productos";
			}
		}
		
		for(String nombre: carrito.keySet()) {
			Producto p=repositorio.getProducto(nombre);
			int cant=carrito.get(nombre);
			p.setStock(p.getStock() - cant);
		}
		
		carrito.clear();
		model.addAttribute("mensaje", "Compra realizada correctamente");
		
		model.addAttribute("productos", repositorio.getProductos());
		model.addAttribute("carrito",carrito);
		
		return "productos";
	}
	
}
