package com.bolsadeideas.springboot.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
//Ahora este objeto dura, lo que dura una peticion HTTP
@RequestScope
//Seciones
//Implementamos el Serializable
//@SessionScope
public class Factura implements Serializable {

	// ID de la serializacion
	private static final long serialVersionUID = 946004357128146951L;

	@Value("${factura.descripcion}")
	private String descripcion;
	// Inyectamos el cliente
	@Autowired
	private Cliente cliente;

	// Inyectamos la lista
	@Autowired
	// @Qualifier("itemsFacturaOficina")
	private List<ItemFactura> items;

	// Se ejecuta despues de crear el objetos
	@PostConstruct
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Antonio"));
		descripcion = descripcion.concat(" del cliente: ").concat(cliente.getNombre());
	}

	// Se ejecuta cuando se destruye el objeto
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida: ".concat(cliente.getNombre()));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
