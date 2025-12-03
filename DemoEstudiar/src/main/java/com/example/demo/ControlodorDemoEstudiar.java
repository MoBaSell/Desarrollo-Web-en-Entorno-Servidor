package com.example.demo;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class ControlodorDemoEstudiar {

	@GetMapping("/")
	public String mostrarForm1(InfoForm1 informacion) {
		return "form1";
	}

	 @PostMapping("/form2")
	 public String informacionForm1(@Valid InfoForm1 informacion, 
			 BindingResult resultado) {
		 
		 if(resultado.hasErrors()) {
			 return "form1";
		 }
		 		 return "form2";
	 }
	 
	 @PostMapping("/form3")
	 public String informacionForm2(@Valid InfoForm1 informacion,
			 BindingResult resultado) {

		 if(resultado.hasErrors()) {
			 return "form2";
		 }
		 return "form3";
	 }
	
	 @PostMapping("/form4")
	 public String informacionForm3(InfoForm1 informacion,Model model) {

		 ArrayList<String> info=new ArrayList<>();
		 info.add("Nombre:"+informacion.getNombre());
		 info.add("Edad:"+informacion.getEdad());
		 info.add("Aficciones:"+informacion.getAficciones());
		 
		 
		 model.addAttribute("infoForm1", informacion);
		 return "form4";
	 }
	
	
	
}
