package com.bolsadeideas.springboot.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bolsadeideas.springboot.error.app.errors.UsuarioNoEncontradoException;

//Para manejar errores
@ControllerAdvice
public class ErrorHandlerController {

	// Manejo de diferentes excepciones
	@ExceptionHandler({ ArithmeticException.class })
	public String aritmeticaError(Exception ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());

		// return ("error/aritmetica");
		return ("error/generica");
	}

	@ExceptionHandler({ NumberFormatException.class })
	public String numeroFormatoError(Exception ex, Model model) {
		model.addAttribute("error", "Error: Formato número inválido!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", new Date());

		return ("error/numero-formato");
	}

	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioNoEncontradoException(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "Error: Usuario no encontrado");
		model.addAttribute("message", ex.getMessage());

		return ("error/usuario");
	}
}