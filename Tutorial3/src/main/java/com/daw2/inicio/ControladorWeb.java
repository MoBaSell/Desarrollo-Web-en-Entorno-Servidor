package com.daw2.inicio;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class ControladorWeb implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/resultado").setViewName("resultado");
	}

	@GetMapping("/")
	public String showForm(PersonaForm personaForm) {
		return "formulario";
	}

	@PostMapping("/")
	public String validarInfoPersona(@Valid PersonaForm personaForm, BindingResult vincularResultado) {

		if (vincularResultado.hasErrors()) {
			return "formulario";
		}

		return "/resultado";
	}
}