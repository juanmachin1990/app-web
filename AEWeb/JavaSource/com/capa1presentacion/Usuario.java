package com.capa1presentacion;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Usuario {
	@NotNull
	private Long id;
	@NotNull
	@Length(max=50)
	private String nombre;
	@NotNull
	@Length(max=50)
	private String apellido;
	@NotNull
	@Email(regexp = ".+[@].+[\\.].+")
	private String mail;
	@NotNull
	@Length(max=50)
	private String nombreUsuario;
	@NotNull
	@Length(min=8, max=50)
	private String contrasena;
	@NotNull
	private String tipoUsuario;
	
	public Usuario() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Usuario(@NotNull Long id, @NotNull @Length(max = 50) String nombre,
			@NotNull @Length(max = 50) String apellido, @NotNull @Email(regexp = ".+[@].+[\\.].+") String mail,
			@NotNull @Length(max = 50) String nombreUsuario, @NotNull @Length(min = 8, max = 50) String contrasena,
			@NotNull String tipoUsuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.tipoUsuario = tipoUsuario;
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	
	
	
	
}
