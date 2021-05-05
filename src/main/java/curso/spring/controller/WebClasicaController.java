package curso.spring.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import curso.spring.model.Contacto;

@Controller
@RequestMapping("/webclasica")
public class WebClasicaController {
	
	ArrayList<Contacto> listaContactos = new ArrayList<Contacto>();
	
	@GetMapping("")
	public String portada() {
		return "portada";
	}
	
	@GetMapping("/saludo")
	public String saludo(Model model) {
		
		return "saludo";
	}
	
	@GetMapping("/que")
	public String que() {
		return "que";
	}
	
	@GetMapping("/alta")
	public String altaContacto(Model model, @RequestParam("n") String nombre, @RequestParam(name="a", required=false, defaultValue="MOngo") String apellidos, @RequestParam String telefono, @RequestParam String email ) {
		
		Contacto c = new Contacto(nombre, apellidos, telefono, email);
		
		listaContactos.add(c);
		
		//Si no se redirige se le tiene que pasar el model
		contacto(model);
		return "contacto";
//		return "redirect:contacto";
	}
	
	@GetMapping("/alta/{nombre}/insertar")
	public String altaContacto(Model model, @PathVariable String nombre) {
		String apellidos = "default path";
		String telefono = "default path2";
		String email = "default path3";
		Contacto c = new Contacto(nombre, apellidos, telefono, email);
		
		listaContactos.add(c);
		
		//Si no se redirige se le tiene que pasar el model
		contacto(model);
		return "contacto";
		//return "redirect:contacto";
	}
	
	@GetMapping("/contacto")
	public String contacto(Model model) {
		//Paso un contacto
		model.addAttribute("contacto", new Contacto());
		
		//Lista de prueba
		ArrayList<String> lista = new ArrayList<String>();
		
		lista.add("je");
		lista.add("ja");
		lista.add("ju");
		model.addAttribute("lista", lista);
		
		//Lista de prueba
		listaContactos.add(new Contacto());
		listaContactos.add(new Contacto("Jorge","Caiceo","789789789","yorch@gemeil.com"));
		listaContactos.add(new Contacto("Sergio","Alonso","13123132","sergo@taho.org"));
		model.addAttribute("listaContactos", listaContactos);
		
		return "contacto";
	}
}
