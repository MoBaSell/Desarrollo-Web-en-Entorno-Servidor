package com.daw2.inicio;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorSaludo {

  @GetMapping("/saludo")
  public String saludoDe(Model modelo) {
    modelo.addAttribute("saludo", new Saludo());
    return "saludo";
  }

  @GetMapping("/respuesta")
  public String enviarSaludo(@ModelAttribute Saludo greeting, Model modelo) {
    modelo.addAttribute("saludo", greeting);
    return "resultado";
  }

}