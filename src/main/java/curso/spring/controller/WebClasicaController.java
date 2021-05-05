package curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/webclasica")
public class WebClasicaController {
	
	@GetMapping("")
	public String portada() {
		return "portada";
	}
	
	@GetMapping("/que")
	public String que() {
		return "que";
	}
	
	@GetMapping("/contacto")
	public String contacto() {
		return "contacto";
	}
}
