package com.bolsadeideas.springboot.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;

//import java.util.HashMap;
//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.bolsadeideas.springboot.form.app.editors.NombreMayusculaEditor;
import com.bolsadeideas.springboot.form.app.editors.PaisPropertyEditor;
import com.bolsadeideas.springboot.form.app.editors.RolesEditor;
import com.bolsadeideas.springboot.form.app.models.domain.Pais;
import com.bolsadeideas.springboot.form.app.models.domain.Role;
import com.bolsadeideas.springboot.form.app.models.domain.Usuario;
import com.bolsadeideas.springboot.form.app.services.PaisService;
import com.bolsadeideas.springboot.form.app.services.RoleService;
import com.bolsadeideas.springboot.form.app.validation.UsuarioValidador;

import jakarta.validation.Valid;

@Controller
//Para mantener valores que no se pasan a los inputs del formulario como es el caso del ID
@SessionAttributes("usuario")
public class FormController {

	@Autowired
	private UsuarioValidador validador;

	@Autowired
	private PaisService paisService;

	@Autowired
	private PaisPropertyEditor paisEditor;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RolesEditor rolesEditor;

	// Otra forma de validar con la clase
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);

		// Validacion de formato del campo fecha
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		// Analizador extricto
		dateFormat.setLenient(false);

		binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, false));

		// Para poner en mayúscula el nombre
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());

		binder.registerCustomEditor(Pais.class, "pais", paisEditor);

		binder.registerCustomEditor(Role.class, "roles", rolesEditor);

	}

	@ModelAttribute("genero")
	public List<String> genero() {
		return Arrays.asList("Hombre", "Mujer");
	}

	@ModelAttribute("listaRolesString")
	public List<String> listaRolesString() {
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMIN");
		roles.add("ROLE_USER");
		roles.add("ROLE_MODERATOR");

		return roles;
	}

	@ModelAttribute("listaRolesStringMap")
	public Map<String, String> listaRolesStringMap() {
		Map<String, String> roles = new HashMap<String, String>();
		roles.put("ROLE_ADMIN", "Administrador");
		roles.put("ROLE_USER", "Usuario");
		roles.put("ROLE_MODERATOR", "Moderador");

		return roles;
	}

	@ModelAttribute("listaRoles")
	public List<Role> listaRoles() {

		return this.roleService.listar();
	}

	// Metodo retorna datos para poder usarse en cualquier vista del controlador
	@ModelAttribute("listaPaises")
	public List<Pais> listaPaises() {
//		return Arrays.asList(new Pais(1, "ES", "España"), new Pais(2, "MX", "México"), new Pais(3, "CL", "Chile"),
//				new Pais(4, "PE", "Perú"), new Pais(5, "NO", "Noruega"), new Pais(1, "IT", "Italia"),
//				new Pais(1, "EC", "Ecuador"));
		return paisService.listar();
	}

	// Metodo retorna datos para poder usarse en cualquier vista del controlador
	@ModelAttribute("paises")
	public List<String> paise() {
		return Arrays.asList("España", "México", "Chile", "Perú", "Noruega", "Italia", "Ecuador");
	}

	// Metodo retorna datos para poder usarse en cualquier vista del controlador
	@ModelAttribute("paisesMap")
	public Map<String, String> paisesMap() {
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("ES", "España");
		paises.put("MX", "México");
		paises.put("CL", "Chile");
		paises.put("PE", "Perú");
		paises.put("NO", "Noruega");
		paises.put("IT", "Italia");
		paises.put("EC", "Ecuador");

		return paises;
	}

	// Mostramos el formulario por GET
	@GetMapping("/form")
	public String form(Model model) {

		// Para que no de error los values de los imputs
		Usuario usuario = new Usuario();

		// Pasamos algunos datos al formulario
		usuario.setNombre("Jesus");
		usuario.setApellido("Anes");

		// Queremos mantener el ID sin necesidad enviarlo a un input en el formulario
		usuario.setIdentificador("123.545.345-J");

		// Id que queremos validar con expresion regular
		usuario.setIDparaValidar("12.545.345-J");

		usuario.setHabilitar(true);

		usuario.setValorSecreto("Algún valor secreto ****");

		// Ahora queremos quedar marcado una opcion en el select
		usuario.setPais(new Pais(5, "NO", "Noruega"));

		// Ahora queremos quedar marcado una opcion en el checkbox
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USER")));

		model.addAttribute("usuario", usuario);

		model.addAttribute("titulo", "Formulario usuario");

		return "form";
	}

//Método que se invoca con peticion POST
	@PostMapping("/form")
	// De esta forma recibimos de forma automatica los datos del formulario, hay que
	// tener en cuenta que los nombres de los imputs deben de coincudir
	// con el nombre de los atrivutos del objeto
	// @Valid para validaciones
	// BindingResult obtenemos los resultados de la validaciones
	// Tiene que ir justo despues del objeto a validar
	// SessionStatus manejo de sesion
	// public String procesar(@Valid Usuario usuario, BindingResult result, Model
	// model, SessionStatus status) {
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {

		// Para las validaciones desde la clase
		// validador.validate(usuario, result);

//		public String procesar(Usuario usuario, Model model, @RequestParam String username, @RequestParam String password,
//				@RequestParam String email) {

//		Usuario usuario = new Usuario();

//		usuario.setUsername(username);
//		usuario.setPassword(password);
//		usuario.setEmail(email);

		if (result.hasErrors()) {

			model.addAttribute("titulo", "Resultado form");

			// Pasamos el mensaje de error
			// Comentamos por optimizacion
//			Map<String, String> errores = new HashMap<>();
//
//			result.getFieldErrors().forEach(err -> {
//				errores.put(err.getField(),
//						"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
//			});
//
//			model.addAttribute("error", errores);

			return "form";
		}

		// model.addAttribute("usuario", usuario);
		// Cerramos la sesion
		// status.setComplete();

//		model.addAttribute("username", username);
//		model.addAttribute("password", password);
//		model.addAttribute("email", email);

		return "redirect:/ver";
	}

	// Con este método vamos a evitar que el usuario al recargar la pagina pueda
	// reenviar el formulario
	// Obtenemos el usuario por la sesion con @SessionAttribute("usuario")
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name = "usuario", required = false) Usuario usuario, Model model,
			SessionStatus status) {

		if (usuario == null) {
			return "redirect:/form";
		}
		model.addAttribute("titulo", "Resultado form");

		status.setComplete();
		return "resultado";
	}
}
