package com.daw2.inicio;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PersonaForm {

	@NotNull
	@Size(min=2, max=30)
	private String nombre;

	@NotNull
	@Min(18)
	private Integer anio;

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAnio() {
		return anio;
	}

	public void setAnio(Integer anio) {
		this.anio = anio;
	}

	public String toString() {
		return "Persona(Nombre: " + this.nombre + ", Anios: " + this.anio + ")";
	}
}