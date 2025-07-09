package com.bolsadeideas.springboot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LocaleController {

	//Usamos este metodo para en la paginacion mantener los parametros de la url
	@GetMapping("/locale")
	public String locale(HttpServletRequest request) {
		// Obtenemos el link de nuestra ultima página
		String ultimaUrl = request.getHeader("referer");

		return "redirect:".concat(ultimaUrl);
	}
}
