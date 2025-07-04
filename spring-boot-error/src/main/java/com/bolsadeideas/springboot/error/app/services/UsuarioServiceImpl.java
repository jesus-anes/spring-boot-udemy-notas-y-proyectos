package com.bolsadeideas.springboot.error.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.error.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;

	public UsuarioServiceImpl() {
		this.lista = new ArrayList<>();
		lista.add(new Usuario(1, "Jesus", "Anes"));
		lista.add(new Usuario(2, "Lalo", "Redondo"));
		lista.add(new Usuario(3, "Lucia", "Martínez"));
		lista.add(new Usuario(4, "Maria", "Miguel"));
		lista.add(new Usuario(5, "Isabel", "López"));
		lista.add(new Usuario(7, "Paco", "Jiménez"));
		lista.add(new Usuario(8, "Juan", "Búrdalo"));
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {

		Usuario resultado = null;

		for (Usuario usuario : this.lista) {
			if (usuario.getId().equals(id)) {
				resultado = usuario;
				break;
			}
		}

		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario usuario = this.obtenerPorId(id);
		return Optional.ofNullable(usuario);
	}

}
