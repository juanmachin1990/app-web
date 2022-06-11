package com.capa2LogicaNegocio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;

import com.capa1presentacion.Usuario;
import com.capa3Persistencia.dao.UsuariosPDTDAO;
import com.capa3Persistencia.entities.UsuarioPDT;
import com.capa3Persistencia.exception.PersistenciaException;



@Stateless
@LocalBean

public class GestionUsuarioService implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	UsuariosPDTDAO usuariosPersistenciaDAO;
	
	

	public Usuario fromUsuarioPDT(UsuarioPDT u) {
		Usuario usuario=new Usuario();
		usuario.setId(u.getId().longValue());
		usuario.setNombre(u.getNombre());
		usuario.setApellido(u.getApellido());
		usuario.setMail(u.getMail());
		usuario.setNombreUsuario(u.getNombreUsuario());
		usuario.setContrasena(u.getContrasena());
		usuario.setTipoUsuario(u.getTipoUsuario());
		return usuario;
	}
	public UsuarioPDT toUsuarioPDT(Usuario u) {
		UsuarioPDT usuarioPDT=new UsuarioPDT();
		usuarioPDT.setId(u.getId()!=null?u.getId().longValue():null);
		usuarioPDT.setNombre(u.getNombre());
		usuarioPDT.setApellido(u.getApellido());
		usuarioPDT.setMail(u.getMail());
		usuarioPDT.setNombreUsuario(u.getNombreUsuario());
		usuarioPDT.setContrasena(u.getContrasena());
		usuarioPDT.setTipoUsuario(u.getTipoUsuario());
		return usuarioPDT;
	}


	
	// servicios para capa de Presentacion

	

	

	public List<Usuario> seleccionarUsuarios() throws PersistenciaException {
		//buscamos todos los  objetos EmpleadoEmpresa
		List<UsuarioPDT> listaUsuarioPDT = usuariosPersistenciaDAO.buscarUsuarios();
		
		List<Usuario> listaUsuarios=new ArrayList<Usuario>();
		//recorremos listaEmpleadosEmpresa y vamos populando listaEmpleado (haciendo la conversion requerida)
		for (UsuarioPDT usuarioPDT : listaUsuarioPDT) {
			listaUsuarios.add(fromUsuarioPDT(usuarioPDT));
		}
		return listaUsuarios;
	}


	/*public List<Usuario> seleccionarUsuarios(String criterioNombre,String criterioDepartamento,Boolean criterioActivo) throws PersistenciaException {
		//buscamos empleados segun criterio indicado
		List<EmpleadoEmpresa> listaEmpleadosEmpresa = empleadosPersistenciaDAO.seleccionarEmpleados(criterioNombre,criterioDepartamento,criterioActivo);
		//lista para devolver la seleccion de empleados
		List<Empleado> listaEmpleados=new ArrayList<Empleado>();
		//recorremos listaEmpleadosEmpresa y vamos populando listaEmpleado (haciendo la conversion requerida)
		for (EmpleadoEmpresa empleadoEmpresa : listaEmpleadosEmpresa) {
			listaEmpleados.add(fromEmpleadoEmpresa(empleadoEmpresa));
		}
		return listaEmpleados;
		
	}
	
	
	public Empleado buscarEmpleadoEmpresa(Long id) {
		EmpleadoEmpresa e = empleadosPersistenciaDAO.buscarEmpleado(id);
		return fromEmpleadoEmpresa(e);
	}*/

	public Usuario buscarUsuario(Long i) {
		UsuarioPDT u = usuariosPersistenciaDAO.buscarUsuario(i);
		return fromUsuarioPDT(u);
	}
	
	public Usuario buscarUsuarioPorUsuarioNombre(String NombreUsuario) throws PersistenciaException {
		UsuarioPDT u = usuariosPersistenciaDAO.buscarUsuarioPorUsuarioNombre(NombreUsuario);
		return fromUsuarioPDT(u);
	}
		
	public Usuario agregarUsuario(Usuario usuarioSeleccionado) throws PersistenciaException   {
		UsuarioPDT e = usuariosPersistenciaDAO.agregarUsuario(toUsuarioPDT(usuarioSeleccionado));
		return fromUsuarioPDT(e);
	}

	/*public void actualizarEmpleado(Empleado empleadoSeleccionado) throws PersistenciaException   {
		EmpleadoEmpresa e = empleadosPersistenciaDAO.modificarEmpleado(toEmpleadoEmpresa(empleadoSeleccionado));
	}*/
	
	
}
