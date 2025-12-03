package com.daw2.inicio;

import java.util.ArrayList;
import java.util.Arrays;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Cookies {
	
@NotNull
private ArrayList<String> estudiosSeleccionados=new ArrayList<>();
	
@NotNull
@Min(1)
@Max(100)
private Integer edad;

@NotNull
@Size(min = 1, max = 1)
private String genero;

@NotNull
@Size(max=50)
private String nombre;

public Integer getEdad() {
	return edad;
}

public void setEdad(Integer edad) {
	this.edad = edad;
}

public String getGenero() {
	return genero;
}

public void setGenero(String genero) {
	this.genero = genero;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre=nombre;
}

public ArrayList<String> getEstudiosSeleccionados() {
	return estudiosSeleccionados;
}

public void setEstudiosSeleccionados(ArrayList<String> estudiosSeleccionados) {
	this.estudiosSeleccionados = estudiosSeleccionados;
}

@Override
public String toString() {
	return "InfoForm [estudiosSeleccionados=" + estudiosSeleccionados + ", edad=" + edad + ", genero=" + genero
			+ ", nombre=" + nombre + "]";
}












}
