package com.daw2.inicio;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

@Controller
public class ControladorWeb {

	@GetMapping("/")
	public String mostrarForm1(Model model) {
		model.addAttribute("InfoForm",new InfoForm());
		return "form1";
	}
	
	@GetMapping("/form1")
	public String mostrarForm1Get(Model model,InfoForm datos) {
		model.addAttribute("InfoForm",datos);
		return "form1";
	}
	
	@GetMapping("/form2")
	public String mostrarForm2(Model model,InfoForm datos) {
		model.addAttribute("InfoForm",datos);
		return "form2";
	}
	@GetMapping("/form3")
	public String mostrarForm3(Model model,InfoForm datos) {
		model.addAttribute("InfoForm",datos);
		return "form3";
	}
	
	@PostMapping("/form2")
	public String informacionForm1(InfoForm datos, BindingResult resultado, Model model) {
		model.addAttribute("InfoForm",datos);
		return "form2";
	}
	
	@PostMapping("/form3")
	public String informacionForm3(InfoForm datos,BindingResult resultado, Model model) {
		
		model.addAttribute("InfoForm",datos);
		return "form3";
	}
	
	@PostMapping("/resultado")
	public String informacionResultado(InfoForm datos,BindingResult resultado, Model model) {
		ArrayList<String> info=new ArrayList<>();
		info.add("Nombre:"+datos.getNombre());
		info.add("Edad:"+datos.getEdad());
		info.add("Estudios:"+datos.getEstudiosSeleccionados());
		model.addAttribute("Info",info);		
		model.addAttribute("InfoForm",datos);
		return "resultado";
	}
}
