package com.bolsadeideas.springboot.form.app.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.form.app.models.domain.Pais;

//Es lo mismo que @Service
@Component
public class PaisServiceImpl implements PaisService {

	private List<Pais> lista;

	public PaisServiceImpl() {

		this.lista = Arrays.asList(new Pais(1, "ES", "España"), new Pais(2, "MX", "México"), new Pais(3, "CL", "Chile"),
				new Pais(4, "PE", "Perú"), new Pais(5, "NO", "Noruega"), new Pais(1, "IT", "Italia"),
				new Pais(1, "EC", "Ecuador"));
	}

	@Override
	public List<Pais> listar() {

		return lista;
	}

	@Override
	public Pais obtenerPorID(Integer id) {

		Pais resultado = null;

		for (Pais pais : this.lista) {
			if (id.equals(pais.getId())) {
				resultado = pais;
				break;
			}
		}

		return resultado;
	}

}
