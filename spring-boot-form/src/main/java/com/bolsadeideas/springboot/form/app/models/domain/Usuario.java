package com.bolsadeideas.springboot.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import org.springframework.format.annotation.DateTimeFormat;

import com.bolsadeideas.springboot.form.app.validation.IdentificadorRegex;
import com.bolsadeideas.springboot.form.app.validation.Requerido;

//import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {

	// No lo validamos porque no esta como campo en el formulario
	private String identificador;

	// Reglas de validacion

	// Validacion de expresion regular
	// @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	// Anotacion creada por nosotros
	@IdentificadorRegex
	private String IDparaValidar;

	// @NotEmpty(message = "el nombre no puede ser vacío")
	private String nombre;

	// @NotEmpty
	// Anoracion creada por nosotros
	@Requerido
	private String apellido;

	@NotBlank
	@Size(min = 3, max = 8)
	private String username;

	@NotEmpty
	private String password;

	// @NotEmpty
	@Requerido
	// Validacion de email
	@Email(message = "correo con formato incorrecto")
	private String email;

	@NotNull
	@Min(5)
	@Max(5000)
	private Integer cuenta;

	// Validacion de fechas
	@NotNull
	// para fecha pasada a la actual
	@Past
	// @Future
	// @DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaNacimiento;

//	@NotEmpty
//	private String pais;

	// Para validar los objetos importados
	// @Valid
	@NotNull
	private Pais pais;

	private Boolean habilitar;

	@NotEmpty
	private List<Role> roles;

	@NotEmpty
	private String genero;

	private String valorSecreto;

	public String getIDparaValidar() {
		return IDparaValidar;
	}

	public void setIDparaValidar(String iDparaValidar) {
		IDparaValidar = iDparaValidar;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Boolean getHabilitar() {
		return habilitar;
	}

	public void setHabilitar(Boolean habilitar) {
		this.habilitar = habilitar;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getValorSecreto() {
		return valorSecreto;
	}

	public void setValorSecreto(String valorSecreto) {
		this.valorSecreto = valorSecreto;
	}

}
