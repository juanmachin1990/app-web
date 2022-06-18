package com.services;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Administrador;
import com.entities.Aficionado;
import com.entities.Investigador;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Remote
public interface UsuarioBeanEJB_Remote {
	
	//OBTENER USUARIOS
	public List<Usuario> listadoUsuarios();
	
	//INSERTAR USUARIOS
	public Usuario insertarUsuario(Long id, String nombre, String apellido, String nombre_usuario, String contrasena, String mail, String tipoUsuario, String habilitado) throws ServiciosException ;
	public Administrador insertarUsuarioAdministrador(Administrador a) throws ServiciosException;
	public Investigador insertarUsuarioInvestigador(Investigador i) throws ServiciosException;
	public Aficionado insertarUsuarioAficionado(Aficionado a) throws ServiciosException;
	
	//ELIMINAR USUARIOS
	public boolean eliminarUsuario(Long id) throws ServiciosException;
	
	//MODIFICAR USUARIOS
	public boolean modificarAdministrador(Usuario u, String domicilio, int documento, int telefono, String ciudad) throws ServiciosException;
	public boolean modificarInvestigador(Usuario u, String domicilio, int documento, int telefono, String ciudad) throws ServiciosException;	
	public boolean modificarAficionado(Usuario u, String ocupacion) throws ServiciosException;
	
	//LOGUEAR USUARIOS
	public Usuario permitirAcceso (String nombreUsuario, String contrasena) throws ServiciosException;

	public Administrador obtenerAdministrador(Long id_usuario);

	public Investigador obtenerInvestigador(Long id_usuario);

	public Aficionado obtenerAficionado(Long id_usuario);

	
}
