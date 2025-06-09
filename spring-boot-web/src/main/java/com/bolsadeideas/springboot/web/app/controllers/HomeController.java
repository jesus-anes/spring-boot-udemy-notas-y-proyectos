package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// Redirigimos a una vista
	//Diferentes metodos
	@GetMapping("/")
	public String home() {
//		return "redirect:/app/index";
//		return "redirect:https://www.google.com";
		//forward para rutas propias del proyecto
		return "forward:/app/index";
	}
}
