package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // Marca la clase como controlador Spring MVC
public class FormularioCONTROLLER { // Convención de nombres en Java (Controller en PascalCase)

    // Paso 1: mostrar el primer formulario
    @GetMapping("/")
    public String verForm1() {
        // No es obligatorio añadir atributos aquí; la vista puede leer valores nulos sin problema
        return "form1"; // Renderiza form1.html
    }

    // Paso 2: procesar nombre y mostrar el segundo formulario
    @PostMapping("/form2")
    public String verForm2(
            @RequestParam(value = "nombre", required = false) String nombre, // Recibe el parámetro "nombre"
            Model model // Modelo para pasar datos a la vista
    ) {
        // Validación del nombre: no nulo y no vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            // Mantener el valor (aunque esté vacío) y añadir mensaje de error
            model.addAttribute("nombre", nombre);
            model.addAttribute("errorNombre", "Debes de rellenar el nombre");
            // Volver al formulario 1 si hay error
            return "form1";
        }
        // Sin errores: propagar el nombre al siguiente formulario
        model.addAttribute("nombre", nombre);
        return "form2"; // Renderiza form2.html
    }

    // Paso 3: procesar apellido y mascota; mostrar el formulario de salidas
    @PostMapping("/form3")
    public String verForm3(
            @RequestParam(value = "nombre", required = false) String nombre,     // Llega desde form2 (hidden)
            @RequestParam(value = "apellido", required = false) String apellido, // Campo visible en form2
            @RequestParam(value = "mascota", required = false) String mascota,   // Radio en form2
            Model model
    ) {
        // Validación del apellido
        if (apellido == null || apellido.trim().isEmpty()) {
            // Mantener lo introducido y mostrar el error en form2
            model.addAttribute("nombre", nombre);
            model.addAttribute("apellido", apellido);
            model.addAttribute("mascota", mascota);
            model.addAttribute("errorApellido", "Debes de rellenar el apellido");
            return "form2";
        }
        // Sin errores: propagar datos al siguiente formulario
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        model.addAttribute("mascota", mascota);
        return "form3"; // Renderiza form3.html
    }

    // Paso 4: procesar salidas; si OK, mostrar el resultado final; si no, volver a form3
    @PostMapping("/resultado")
    public String verResultado(
            @RequestParam(value = "nombre", required = false) String nombre,       // Hidden desde form3
            @RequestParam(value = "apellido", required = false) String apellido,   // Hidden desde form3
            @RequestParam(value = "mascota", required = false) String mascota,     // Hidden desde form3
            @RequestParam(value = "salidas", required = false) String[] salidas,   // Checkboxes; puede venir null
            Model model
    ) {
        // Validación: debe elegir al menos una salida
        if (salidas == null || salidas.length == 0) {
            // Mantener valores, añadir mensaje de error y volver a form3
            model.addAttribute("nombre", nombre);
            model.addAttribute("apellido", apellido);
            model.addAttribute("mascota", mascota);
            model.addAttribute("salidas", salidas); // Puede ser null; la vista lo maneja
            model.addAttribute("errorSalidas", "Debes elegir al menos una opción");
            return "form3";
        }
        // Sin errores: preparar datos para la vista de resultado
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        model.addAttribute("mascota", mascota);
        model.addAttribute("salidas", salidas);
        return "resultado"; // Renderiza resultado.html
    }
}
