package com.bean;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.services.UsuarioBeanEJB;
@Named(value="usuario")
@RequestScoped
public class UsuarioBean {
	
	private Long id_usuario;
	private String nombre;
	private String apellido;
	private String mail;
	private String nombre_usuario;
	private String contrasena;
	private String tipo;
	private String habilitado;
	
	@EJB
	private UsuarioBeanEJB usuariosBeanEJB;
	
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}


	public String crearUsuario(){
		try{
			usuariosBeanEJB.insertarUsuario(id_usuario, nombre, apellido, nombre_usuario, contrasena, mail, tipo, habilitado);
			return "mostrar";
		}catch(Exception e){
			return null;
		}

	}
}
