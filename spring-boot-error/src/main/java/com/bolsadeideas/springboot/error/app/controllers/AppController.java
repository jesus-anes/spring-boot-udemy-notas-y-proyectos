package com.bolsadeideas.springboot.error.app.controllers;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;
import com.bolsadeideas.springboot.error.app.models.domain.Usuario;
import com.bolsadeideas.springboot.error.app.services.UsuarioService;
import com.bolsadeideas.springboot.error.app.services.UsuarioServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AppController {

	@Autowired
	private UsuarioService usuarioService;

	// para que no salga la advertencia del 100/0
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {

		// Forzamos un error
		// Integer valor = 100/0;
		Integer valor = Integer.parseInt("10x");

		return "index";
	}

	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model model) {

		// Usuario usuario = usuarioService.obtenerPorId(id);

		// Manejamos el error de usuario no encontrado con una clase personalizada
//		if (usuario == null) {
//			throw new UsuarioNoEncontradoException(id.toString());
//		}

		// esto hace la funcion de lo comentado arriba, pero usando el metodo
		// "obtenerPorIdOptional"
		Usuario usuario = usuarioService.obtenerPorIdOptional(id)
				.orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));

		return "ver";
	}

}
