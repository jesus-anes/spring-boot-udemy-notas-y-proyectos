package com.bolsadeideas.springboot.di.app.models.service;

import org.springframework.stereotype.Component;

//Otra forma sería @Service
//@Component("miServicioSimple")

//Con @Primary hacemos que este servicio tenga prioridad
//@Primary

//Implementamos una interface
public class MiServicio implements IServicio {

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple...";
	}
}
