package com.example.demo;

import java.util.ArrayList;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class InfoForm1 {
	
	@NotBlank(message ="El campo no puede estar vacio")
	@Size(min=2,max=30)
	private String nombre = "";
	
	@NotNull(message ="El campo no puede estar vacio")
	@Min(value=1,message="La edad es 1")
	@Max(value=100,message="La edad maxima es 100")
	private Integer edad = 50;

	private ArrayList<String> aficciones = new ArrayList<>();
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public ArrayList<String> getAficciones() {
		return aficciones;
	}

	public void setAficciones(ArrayList<String> aficciones) {
		this.aficciones = aficciones;
	}
	
	
	
}
