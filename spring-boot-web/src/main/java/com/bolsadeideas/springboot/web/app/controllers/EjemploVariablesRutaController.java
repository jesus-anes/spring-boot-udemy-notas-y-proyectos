package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("titulo", "Enviar parámetros de la ruta (@PathVariable)");

		return "variables/index";
	}

	// Otra forma de pasar variables, más limpia y amigable
	@GetMapping("/string/{texto}")
	// El nombre del parametro tiene que ser igual al de la ruta, sino usar el
	// atrivuto name=""
	public String variables(@PathVariable String texto, Model model) {

		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);

		return "variables/ver";
	}

	// Mas de una variable
	@GetMapping("/string/{texto}/{numero}")
	// El nombre del parametro tiene que ser igual al de la ruta, sino usar el
	// atrivuto name=""
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {

		model.addAttribute("titulo", "Recibir parámetros de la ruta (@PathVariable)");
		model.addAttribute("resultado",
				"El texto enviado en la ruta es: " + texto + " el numero enviado es: " + numero);

		return "variables/ver";
	}

}
