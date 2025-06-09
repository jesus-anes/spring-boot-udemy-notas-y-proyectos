package com.bolsadeideas.springboot.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

//Ejercicio de ejemplo
@Component
//Ahora este objeto dura, lo que dura una peticion HTTP
@RequestScope
public class Cliente {

	// Los valores se los damos desde el properties
	@Value("${cliente.nombre}")
	private String nombre;

	// Los valores se los damos desde el properties
	@Value("${cliente.apellido}")
	private String apellido;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

}
