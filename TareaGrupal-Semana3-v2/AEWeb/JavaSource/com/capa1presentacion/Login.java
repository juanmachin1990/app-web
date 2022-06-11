package com.capa1presentacion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.capa2LogicaNegocio.GestionUsuarioService;
import com.capa3Persistencia.exception.PersistenciaException;

@SessionScoped @Named
public class Login implements Serializable {

	@Inject
	GestionUsuarioService persistenciaBean;
	
	private static final long serialVersionUID = 1L;

	private String nombreUsuario ;
	private String contrasenaUsuario ;
	private Usuario usuarioLogueado;
	
	@PostConstruct
	public void init() {
		setUsuarioLogueado(new Usuario());
	}

	public String login() {
		Usuario usuario;
		FacesMessage facesMsg;
		
		try {
			usuario = (Usuario) persistenciaBean.buscarUsuarioPorUsuarioNombre(nombreUsuario);
			// validar ContraseÃ±a
			String contrasenaABuscar   = usuario.getContrasena();
			if (contrasenaABuscar.equals(contrasenaUsuario) ) {
				// mensaje de login correcta
				facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Se ingresó correctamente", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);				
			}else {
				// mensaje de login incorrecto
				facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Contraseña incorrecta", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);		
			}
			setUsuarioLogueado(usuario);
			return "index";	
				
		} catch (NullPointerException | PersistenciaException e) {

			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existe usuario", "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			e.printStackTrace();			
			return facesMsg.toString() ;
		} 	
			
	
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasenaUsuario() {
		return contrasenaUsuario;
	}

	public void setContrasenaUsuario(String contrasenaUsuario) {
		this.contrasenaUsuario = contrasenaUsuario;
	}

	public Usuario getUsuarioLogueado() {
		return usuarioLogueado;
		
	}

	public void setUsuarioLogueado(Usuario usuarioLogueado) {
		this.usuarioLogueado = usuarioLogueado;
		
	}

	
}
