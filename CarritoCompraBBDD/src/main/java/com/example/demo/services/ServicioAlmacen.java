package com.example.demo.services;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entities.ProductoAlmacen;
import com.example.demo.repositories.RepositorioProductoAlmacen;

@Service
public class ServicioAlmacen {
	private RepositorioProductoAlmacen repositorioProductoAlmacen;
	
	public ServicioAlmacen(RepositorioProductoAlmacen repositorioProductoAlmacen) {
		this.repositorioProductoAlmacen=repositorioProductoAlmacen;
		if (repositorioProductoAlmacen.count()==0) {
			repositorioProductoAlmacen.save(new ProductoAlmacen("Platanos",3.5,100));
			repositorioProductoAlmacen.save(new ProductoAlmacen("Peras",2.5,100));
			repositorioProductoAlmacen.save(new ProductoAlmacen("Brocoli",2.5,100));
			repositorioProductoAlmacen.save(new ProductoAlmacen("Batata",1.5,100));
		}
	}
	
	public List<ProductoAlmacen> getAll(){
		return (List<ProductoAlmacen>) repositorioProductoAlmacen.findAll();
	}
	
	// resta del stock la cantidad recibida de cada producto si es pocible
	public void restaStock(Map<String,String> productos) {
		for (String producto:productos.keySet()) {
			ProductoAlmacen productoAlmacen= repositorioProductoAlmacen.findById(producto).orElse(null);
			if(productoAlmacen!=null) {
				productoAlmacen.setStock(productoAlmacen.getStock()-Integer.parseInt(productos.get(producto)));
				repositorioProductoAlmacen.save(productoAlmacen);				
			}else {
				System.err.println("Error producto no encontrado en BD: "+producto);
			}
		}
	}
}
