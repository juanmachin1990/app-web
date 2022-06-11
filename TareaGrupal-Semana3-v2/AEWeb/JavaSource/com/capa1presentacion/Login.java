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
	
	@PostConstruct
	public void init() {
	//	nombreUsuario     = new String();
	//	contrasenaUsuario = new String();
	}

	public String login() {
		Usuario usuario;
		FacesMessage facesMsg;
		
		try {
			usuario = (Usuario) persistenciaBean.buscarUsuarioPorUsuarioNombre(nombreUsuario);
			// validar Contraseña
			String contrasenaABuscar   = usuario.getContrasena();
			if (contrasenaABuscar.equals(contrasenaUsuario) ) {
				// mensaje de login correcta
				facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
						"Ingresó correctamente.", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);				
			}else {
				// mensaje de login incorrecto
				facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Contraseña Incorrecta.", "");
				FacesContext.getCurrentInstance().addMessage(null, facesMsg);		
			}
			return facesMsg.toString() ;	
				
		} catch (NullPointerException | PersistenciaException e) {

			facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No existe usuario.", "");
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

	/*public void logout() {
		user = null;
	}

	public boolean isLoggedIn() {
		return user != null;
	}

	@Produces @LoggedIn User getCurrentUser() {
		return user;
	}*/
}
