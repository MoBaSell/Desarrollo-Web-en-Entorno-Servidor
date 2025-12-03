package com.daw2.inicio;


import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

@Controller
public class ControladorCookies {

	@GetMapping("/")
	public String mostrarForm1(Model model) {
		model.addAttribute("InfoForm",new Cookies());
		return "form1";
	}
	
	@GetMapping("/form1")
	public String mostrarForm1Get(Model model,Cookies datos) {
		
		model.addAttribute("InfoForm",datos);
			
		return "form1";
	}
	
	@GetMapping("/form2")
	public String mostrarForm2(Model model,Cookies datos) {
		model.addAttribute("InfoForm",datos);
		return "form2";
	}
	@GetMapping("/form3")
	public String mostrarForm3(Model model,Cookies datos) {
		model.addAttribute("InfoForm",datos);
		return "form3";
	}
	
	@PostMapping("/form2")
	public String informacionForm1(Cookies datos, BindingResult resultado, Model model,@CookieValue(value="nombre",required=true) String token,HttpServletResponse response) {
		model.addAttribute("InfoForm",datos);
		if(token!=null) {
			return "Ya has iniciado sesion";
		}
		Cookie cookie= new Cookie("nombre","pepe");
		cookie.setMaxAge(3600);
		cookie.setSecure(true);
		cookie.setHttpOnly(true);
		cookie.setPath("/form3");
		response.addCookie(cookie);
		return "form2";
	}
	
	@PostMapping("/form3")
	public String informacionForm3(Cookies datos,BindingResult resultado, Model model) {
		
		model.addAttribute("InfoForm",datos);
		return "form3";
	}
	
	@PostMapping("/resultado")
	public String informacionResultado(Cookies datos,BindingResult resultado, Model model) {
		ArrayList<String> info=new ArrayList<>();
		info.add("Nombre:"+datos.getNombre());
		info.add("Edad:"+datos.getEdad());
		info.add("Estudios:"+datos.getEstudiosSeleccionados());
		model.addAttribute("Info",info);		
		model.addAttribute("InfoForm",datos);
		return "resultado";
	}
}
