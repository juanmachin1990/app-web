package com.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value="gestionUsuario")
@SessionScoped
public class GestionUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioBean usuario;

	public GestionUsuario() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		usuario = new UsuarioBean();
	}
	
	public String crearUsuario() {
		UsuarioBean usuarioBean =  new UsuarioBean();
		usuarioBean.crearUsuario(this.usuario);
		return "mostrar";		
	}
	
	public String irLogin() {
		return "Login";
	}
	public String irCrearUsuario() {
		return "index";
	}
	public String irAltaUsuario() {
		return "AltaUsuario";
	}

	public UsuarioBean getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

}
