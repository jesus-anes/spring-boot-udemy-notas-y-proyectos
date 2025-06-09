package com.bolsadeideas.springboot.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bolsadeideas.springboot.di.app.models.service.IServicio;

@Controller
public class IndexController {

	//Injectamos un objeto con esta anotacion
//	@Autowired
//	private MiServicio servicio;
	
	//Vamos a usar una interface en vez de una clase concreta
	@Autowired
	//Para inyectar por el nombre del servicio
	//@Qualifier("miServicioSimple")
	private IServicio servicio;

	//Diferentes maneras de inyectar el servicio
//	@Autowired
//	public IndexController(IServicio servicio) {
//				this.servicio = servicio;
//	}

	@GetMapping({ "/index", "/", "" })
	public String index(Model model) {
		
		model.addAttribute("objeto", servicio.operacion());
		
		return "index";
	}

	//Diferentes maneras de inyectar el servicio
//	@Autowired
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}
	
	
}
