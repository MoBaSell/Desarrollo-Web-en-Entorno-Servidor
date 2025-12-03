package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class controladorLogin {
	
	private final String USUARIO_VALIDO = "MohaBada";
	private final String CONTRASENIA_VALIDA = "Moha123";

	@GetMapping("/login")
	public String mostrarLogin(HttpSession sesion) {
		
		Boolean iniciado=(Boolean) sesion.getAttribute("autentificado");
		if(iniciado != null && iniciado) {
			return "redirect:/";
		}
		
		return "login";
	}
	
	@PostMapping("/login")
	public String porcesarLogin(@RequestParam("usuario") String usuario, 
								@RequestParam("contrasenia") String contrasenia,
								HttpSession sesion,
								Model modelo){
		
		if(USUARIO_VALIDO.equals(usuario) && CONTRASENIA_VALIDA.equals(contrasenia)) {
			
			sesion.setAttribute("autentificado", true);
			sesion.setAttribute("usuario", usuario);
			return "redirect:/";			
		}else {
            modelo.addAttribute("error", "Usuario o contraseña incorrectos");
            modelo.addAttribute("usuarioAnterior", usuario);
            return "login";
        }		
	}
	
	@GetMapping("/")
	public String mostrarRaiz(HttpSession sesion) {
		Boolean iniciado=(Boolean) sesion.getAttribute("autentificado"); 
		
		if(iniciado == null || !iniciado) {
			return "redirect:/login";
		}
		
		return "redirect:/pagina1";
	}
	
	 @GetMapping("/pagina1")
	 public String mostrarPagina1(HttpSession sesion) {
	 Boolean iniciado = (Boolean) sesion.getAttribute("autentificado");

        if (iniciado == null || !iniciado) {
            return "redirect:/login";
        }

	        return "pag1";
	    }
	
	 @GetMapping("/pagina2")
	 public String mostrarPagina2(HttpSession sesion) {
	 Boolean iniciado = (Boolean) sesion.getAttribute("autentificado");

        if (iniciado == null || !iniciado) {
            return "redirect:/login";
        }

	        return "pag2";
	    }
	 
	 @GetMapping("/cerrar")
	    public String cerrarSesion(HttpSession sesion) {
	        sesion.invalidate(); // borra toda la sesión
	        return "redirect:/login";
	    }
}
