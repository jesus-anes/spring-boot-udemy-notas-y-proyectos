package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

//Controlador Index
@Controller
//Ruta para todos los metodos del controlador
@RequestMapping("/app")
public class IndexController {

	// Valores provenientes de textos.properties
	//Configurado en TextosPropertiesConfig.java
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	// Devuelve un String porque es el nombre de la vista que devuelve
	// Ruta de la vista
	// con "{}" podemos añadir más rutas al mismo método
	@GetMapping({ "/index", "/", "home", "" })
//	@GetMapping("/index")
	// Model para pasar datos a la vista
	// Tambien se puede usar ModelMap, que es como Map de Java util
	// Y por supuesto tambien podemos usar Map
	public String index(Model model) {

		model.addAttribute("titulo", textoIndex);

		// Nombre de la vista
		return "index";
	}

	// Con ModelAndView
//	public ModelAndView index(ModelAndView mv) {
//
//		mv.addObject("titulo", "Hola mundo");
	// Asignamos el nombre de la vista
//		mv.setViewName("index");
//
//		return mv;
//	}

	// Mostramos otra vista con los datos de un usuario
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario();

		usuario.setNombre("Jesus");
		usuario.setApellido("Anes");
//		usuario.setEmail("jesus@gmail.com");

		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));

		return "perfil";
	}

	@RequestMapping("listar")
	public String listar(Model model) {

//		List<Usuario> usuarios = new ArrayList<>();
//				
//		usuarios.add(new Usuario("Jesus", "Anes", "jesus@gmail.com"));
//		usuarios.add(new Usuario("Maria", "Anes", "jesus@gmail.com"));
//		usuarios.add(new Usuario("Pedro", "Anes", "jesus@gmail.com"));

		// Forma más óptima
//		List<Usuario> usuarios = Arrays.asList(new Usuario("Jesus", "Anes", "jesus@gmail.com"),
//				new Usuario("Maria", "Anes", "maria@gmail.com"), new Usuario("Pedro", "Anes", "pedro@gmail.com"),
//				new Usuario("Andres", "Anes", "andres@gmail.com"));

		model.addAttribute("titulo", textoListar);
//		model.addAttribute("usuarios", usuarios);

		return "listar";
	}

	// De esta forma, usuarios estará disponible para todas las vista y metodos, por
	// eso ya no necesito llamarlos en el metodo "listar"
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios() {

		List<Usuario> usuarios = Arrays.asList(new Usuario("Jesus", "Anes", "jesus@gmail.com"),
				new Usuario("Maria", "Anes", "maria@gmail.com"), new Usuario("Pedro", "Anes", "pedro@gmail.com"),
				new Usuario("Andres", "Anes", "andres@gmail.com"));

		return usuarios;
	}

}
