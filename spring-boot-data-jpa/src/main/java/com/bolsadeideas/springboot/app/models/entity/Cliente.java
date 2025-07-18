package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
//import jakarta.validation.constraints.Size;

//Indicamos que va a ser una entidad
@Entity
//Para indicar el nombre de la tabla
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	// Autoincrementable
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Para cambiar nombre en la base de datos
	// @Column(name = "nombre_cliente")
	@NotEmpty
	// @Size(min = 4, max = 12)
	private String nombre;
	@NotEmpty
	// @Size(min = 4, max = 12)
	private String apellido;
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Column(name = "create_at")
	// Para indicar el formato de como se guarda en la BD
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createAt;

	// Se llama justo antes de insertar en la base de datos
	// @PrePersist
//	public void prePersist() {
//		createAt = new Date();
//	}

	// Relacion con Factura
	// LAZY, no trae todas las relaciones
	// orphanRemoval elimina registros huerfanos que no estén asociados a
	// ningún cliente
	@OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Factura> facturas;

	private String foto;

	// Constructor
	public Cliente() {
		facturas = new ArrayList<Factura>();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public List<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public void addFactura(Factura factura) {
		facturas.add(factura);
	}

	@Override
	public String toString() {
		return nombre + " " + apellido;
	}

	private static final long serialVersionUID = 1L;

}
