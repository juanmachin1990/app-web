package com.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.bean.UsuarioBean;
import com.entities.Usuario;
import com.services.UsuarioBeanEJB;
import com.services.UsuarioBeanEJB_Remote;


@Named(value="gestionUsuario")
@ApplicationScoped
public class GestionUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private UsuarioBean usuario;
	private UsuarioBean usuarioModificar;

	static Long id_usuario = Long.valueOf(0);
	private List<Usuario> usuarios;
	

	public GestionUsuario() {
		
	}

	@PostConstruct
	public void init() {
		
		usuario = new UsuarioBean();
		usuarios = new ArrayList<Usuario>();
	}
	
//	public String crearUsuario() {
//		UsuarioBean usuarioBean =  new UsuarioBean();
//		usuarioBean.crearUsuario(this.usuario);
//		return "mostrar";		
//	}
	public String crearUsuario(){
			
			usuario.setId_usuario(id_usuario);
			
			id_usuario=Long.valueOf(id_usuario.intValue()+1);
			
			usuario.persistirUsuario(Long.valueOf(usuario.getId_usuario()), usuario.getNombre(), usuario.getApellido(), 
					usuario.getNombre_usuario(), usuario.getContrasena(), usuario.getMail(), usuario.getTipo().toString(), "SI");
			
			usuarios.add(usuario.convertirUsuario());
			
			for(Usuario u:usuarios) {
				System.out.println(u.getNombre());
			}
			
			return "mostrar";
		

	}
	
	public void eliminarUsuario(Usuario usuario) {
		usuarios.remove(usuario);
	}
	
	public String irModificarUsuario(Usuario usuarioSeleccionado){
		usuarioModificar = usuario.convertirUsuarioBean(usuarioSeleccionado);
		usuario = usuarioModificar;
		return "modificar";
	}
	
	public String modificarUsuario(){
		int index = buscarIndicePorId(usuarioModificar.getId_usuario());
		System.out.println(index);
		usuarios.set(index, usuario.convertirUsuario());
		return "mostrar";
	}
	
	private int buscarIndicePorId(Long id) {
		for(Usuario u:usuarios) {
			if(u.getId_usuario().equals(id)) {
				return usuarios.indexOf(u);
			}
		}
		return -1;
	}
	public UsuarioBean getUsuario() {
		return usuario;
	}
	
	public String irCrearUsuario() {
		usuario = new UsuarioBean();
		return "index";
	}
	
	public String irMostrarUsuarios() {
		usuario = new UsuarioBean();
		return "mostrar";
	}

	public void setUsuario(UsuarioBean usuario) {
		this.usuario = usuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	

}
