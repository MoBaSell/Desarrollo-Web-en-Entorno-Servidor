package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	 public Usuario() {
		super();
	}
	 public Usuario(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 private Integer id;
	 private String nombre;
	 private String email;
	 public Integer getId() {
		 return id;
	 }
	 public void setId(Integer id) {
		 this.id = id;
	 }
	 public String getNombre() {
		 return nombre;
	 }
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	 }
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
	 @Override
	 public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
	 }
	
}
