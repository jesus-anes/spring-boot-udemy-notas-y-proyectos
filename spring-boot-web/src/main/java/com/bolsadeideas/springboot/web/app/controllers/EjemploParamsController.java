package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	// Vamos a pasar paramatros mediante la url de tipo get con @RequestParam
	// Pasamos string
	@GetMapping("/string")
	public String param(@RequestParam(name = "texto", defaultValue = "Holii") String texto, Model model) {

		model.addAttribute("resultado", "El texto enciado es: " + texto);
		return "params/ver";
	}

	// Vamos a pasar paramatros mediante la url de tipo get con @RequestParam
	// pasamos mas de un parametro y no solo string
	@GetMapping("/mix-params")
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {

		model.addAttribute("resultado", "El texto enciado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

	// Vamos a pasar paramatros mediante la url de tipo get con @RequestParam
	// pasamos mas de un parametro y no solo string
	// Otro método con HttpServletRequest
	@GetMapping("/mix-params-request")
	public String param(HttpServletRequest request, Model model) {

		String saludo = request.getParameter("saludo");
		
		//Controlamos el fallo de que intente convertir un número que no sea in integer
		Integer numero = null;

		try {
			numero = Integer.parseInt(request.getParameter("numero"));
		} catch (NumberFormatException e) {
			// TODO: handle exception
			numero = 0;
		}

		model.addAttribute("resultado", "El texto enciado es: '" + saludo + "' y el número es '" + numero + "'");
		return "params/ver";
	}

}
