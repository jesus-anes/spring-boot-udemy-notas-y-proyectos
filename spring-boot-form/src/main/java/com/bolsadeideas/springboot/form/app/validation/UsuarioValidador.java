package com.bolsadeideas.springboot.form.app.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bolsadeideas.springboot.form.app.models.domain.Usuario;

@Component
public class UsuarioValidador implements Validator {

	// Validacion desde clase
	@Override
	public boolean supports(Class<?> clazz) {

		return Usuario.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		Usuario usuario = (Usuario) target;

		// Validamos que el nombre no esté vacío
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "requerido.usuario.nombre");

		// Es lo mismo que lo de arriba
//		if (usuario.getNombre().isEmpty()) {
//			errors.rejectValue("nombre", "NotEmpty.usuario.nombre");
//		}

		// Validacion
//		if (!usuario.getIDparaValidar().matches("[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
//			errors.rejectValue("IDparaValidar", "pattern.usuario.IDparaValidar");
//		}
	}

}
