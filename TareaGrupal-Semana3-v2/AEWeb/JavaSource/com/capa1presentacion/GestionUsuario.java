package com.capa1presentacion;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.capa2LogicaNegocio.GestionUsuarioService;
import com.capa3Persistencia.exception.PersistenciaException;
import com.utils.ExceptionsTools;
import java.io.Serializable;

@Named("gestionUsuario")
@SessionScoped
public class GestionUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	GestionUsuarioService persistenciaBean;

	private Usuario usuarioSeleccionado;

	public GestionUsuario() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		usuarioSeleccionado = new Usuario();
	}
	// Pasar a modo
	public String salvarCambios() {

		Usuario usuarioNuevo;
		
		try {
			usuarioNuevo = (Usuario) persistenciaBean.agregarUsuario(usuarioSeleccionado);
			// actualizamos id
			Long nuevoId = usuarioNuevo.getId();
			// vaciamos empleadoSeleccionado como para ingresar uno nuevo
			usuarioSeleccionado = new Usuario();

			// mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Se ha agregado un nuevo Usuario con id:" + nuevoId.toString(), "");
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			return facesMsg.toString() ;

		} catch (PersistenciaException e) {

			Throwable rootException = ExceptionsTools.getCause(e);
			String msg1 = e.getMessage();
			String msg2 = ExceptionsTools.formatedMsg(rootException);
			// mensaje de actualizacion correcta
			FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg1, msg2);
			FacesContext.getCurrentInstance().addMessage(null, facesMsg);
			
			e.printStackTrace();
			
			return facesMsg.toString() ;
		} 		
		
	}
	
	public String irLogin() {
		return "Login";
	}
	public String irMostrarUsuario() {
		//response.sendRedirect(request.getContextPath() + "/foo/bar.jsp");
		return "/MostrarDatos.jsp";
	}
	public String irAltaUsuario() {
		return "AltaUsuario";
	}

	public String reset() {
		usuarioSeleccionado = new Usuario();
		return "";
	}

	public GestionUsuarioService getPersistenciaBean() {
		return persistenciaBean;
	}

	public void setPersistenciaBean(GestionUsuarioService persistenciaBean) {
		this.persistenciaBean = persistenciaBean;
	}

	public Usuario getUsuarioSeleccionado() {
		return usuarioSeleccionado;
	}

	public void setUsuarioSeleccionado(Usuario usuarioSeleccionado) {
		this.usuarioSeleccionado = usuarioSeleccionado;
	}

}
