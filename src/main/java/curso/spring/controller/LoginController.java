package curso.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.model.Contacto;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@GetMapping("")
	public String login(Model model, @RequestParam String usuario, @RequestParam(defaultValue="admin") String clave) {
		
		if(usuario.equals("admin") && clave.equals("admin")) {
			model.addAttribute("usuario", usuario);
			
//			WebClasicaController.saludo(model);
//			
//			return "redirect:http://localhost:9090/webclasica/saludo";
			
			WebClasicaController wCC = new WebClasicaController();
			wCC.saludo(model);
			
			
			return wCC.saludo(model);
		}
		else {
			return "redirect:error";
		}
	}
	
	@GetMapping("/{usuario}")
	public String login2(Model model, @PathVariable String usuario, @RequestParam(defaultValue="ad") String clave) {
		
		if(usuario.equals("admin") && clave.equals("admin")) {
			model.addAttribute("usuario", usuario);
			
			WebClasicaController wCC = new WebClasicaController();
			wCC.saludo(model);
			
			return wCC.saludo(model);
		}
		else {
			return "redirect:error";
		}
	}
	
	@GetMapping("/error")
	public String error() {
		
		return "error";
	}
}
