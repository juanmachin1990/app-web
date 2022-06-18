package com.bean;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exceptions.ServiciosException;
import com.services.UsuarioBeanEJB;
@Named(value="usuario")
@ApplicationScoped
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
	private UsuarioBeanEJB usuarioBeanEJB = new UsuarioBeanEJB();
	
	
	public UsuarioBean() {
		
	}
	
	public UsuarioBean(Long id_usuario, String nombre, String apellido, String mail, String nombre_usuario,
			String contrasena, String tipo, String habilitado) {
		
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.mail = mail;
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.tipo = tipo;
		this.habilitado = habilitado;

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
	
	


	public void persistirUsuario(Long id, String nombre, String apellido, String nombre_usuario, String contrasena, 
			String mail, String tipoUsuario, String habilitado){
		try{
			usuarioBeanEJB.insertarUsuario(id,nombre,apellido,nombre_usuario,contrasena,mail,tipoUsuario,habilitado);
		}catch(ServiciosException e){
			System.out.println("error al persistir");
		}

	}
	
	public Usuario convertirUsuario () {
		return new Usuario(id_usuario, nombre, apellido, mail, nombre_usuario, contrasena, TipoUsuario.valueOf(tipo), habilitado);
	}
	
	public UsuarioBean convertirUsuarioBean (Usuario u) {
		return new UsuarioBean(u.getId_usuario(), u.getNombre(), u.getApellido(), u.getMail(), 
				u.getNombre_usuario(), u.getContrasena(), u.getTipo().toString(), u.getHabilitado());
	}
	
	
}
