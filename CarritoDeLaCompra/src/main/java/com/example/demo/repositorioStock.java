package com.example.demo;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class repositorioStock {
	
	private List<Producto> productos=new ArrayList<>();
	
	public repositorioStock() {
		iniciar();
	}

	public void iniciar() {
		
		productos.add(new Producto("p1", "Camiseta", 15, 10));
		productos.add(new Producto("p2", "Gorra", 8, 5));
        productos.add(new Producto("p3", "Zapatilla", 6, 12));
	}
	
	public List<Producto> getProductos() {
        return productos;
    }
	
	public Producto getProducto(String nombre) {
		for(Producto p: productos) {
			if(p.getNombre().equals(nombre)) {
				return p;
			}
		}
		return null;
	}
}
