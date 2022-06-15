package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	//Generamos una secuencia nueva, llamada SEQ_USUARIOS
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIOS" )
	@SequenceGenerator(name = "SEQ_USUARIOS", initialValue = 150, allocationSize = 1)
	
	private Long id_usuario;
	
	@Column(name="NOMBRE",length=50)
	private String nombre;
	
	@Column(name="APELLIDO",length=50)
	private String apellido;
	
	@Column(name="MAIL",length=50)
	private String mail;
	
	@Column(name="NOMBRE_USUARIO",length=50)
	private String nombre_usuario;
	
	@Column(name="CONTRASENA",length=50)
	private String contrasena;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	
	@Column(name="HABILITADO",length=2)
	private String habilitado;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nombre, String apellido, String mail, String nombre_usuario, String contrasena, 
			TipoUsuario tipo, String habilitado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.habilitado = habilitado;
	}

	public Usuario(Long id_usuario, String nombre, String apellido, String mail, String nombre_usuario,
			String contrasena, TipoUsuario tipo, String habilitado) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.habilitado = habilitado;

	}

	public Usuario (Usuario u) {
		this.nombre = u.getNombre();
		this.apellido = u.getApellido();
		this.mail = u.getMail();
		this.nombre_usuario = u.getNombre_usuario();
		this.contrasena = u.getContrasena();
		this.tipo = u.getTipo();
		this.habilitado = u.getHabilitado();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
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

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail
				+ ", nombre_usuario=" + nombre_usuario + ", contrasena=" + contrasena + ", tipo=" + tipo
				+ ", habilitado=" + habilitado + "]";
	}
}
