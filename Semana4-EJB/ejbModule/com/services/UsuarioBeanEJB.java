package com.services;

import java.util.List;

import javax.ejb.LocalBean;
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
@Stateless
@LocalBean
public class UsuarioBeanEJB {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
	public UsuarioBeanEJB() {
		// TODO Auto-generated constructor stub

	}

	public List<Usuario> listadoUsuarios() {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u where HABILITADO='SI'",Usuario.class);
		return query.getResultList();		
	}
	
	/*
	 * Para uso de la tarea semana 4
	 */

	public Usuario insertarUsuario(Long id, String nombre, String apellido, String nombre_usuario, String contrasena, String mail, String tipoUsuario, String habilitado) throws ServiciosException {
		try{
			Usuario u = new Usuario(id, nombre, apellido, mail, nombre_usuario, contrasena, TipoUsuario.valueOf(tipoUsuario), habilitado);
			em.persist(u); 
			em.flush();
			return u;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario");

		}
	}
	

	public Administrador insertarUsuarioAdministrador(Administrador a) throws ServiciosException {
		try{

			em.persist(a); 
			em.flush();
			return a;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario administrador");

		}
	}

	public Investigador insertarUsuarioInvestigador(Investigador i) throws ServiciosException{
		try{

			em.persist(i); 
			em.flush();
			return i;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario investigador");

		}
	}



	public Aficionado insertarUsuarioAficionado(Aficionado a) throws ServiciosException {
		try{
			em.persist(a); 
			em.flush();
			System.out.println(a);
			return a;
		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo crear el usuario investigador");

		}
	}

	
	//Borrado lógico del usuario
	public boolean eliminarUsuario(Long id) throws ServiciosException {
		try{
			Usuario u = em.find(Usuario.class, id);
			/*
			if(u.getRol().equals(TipoUsuario.ADMINISTRADOR.toString())) {
				Administrador a = (Administrador) em.createNamedQuery("Administrador.obtenerPorId_Usuario")
						.setParameter("id_usuario", id)
						.getResultList().get(0);
				em.remove(a);
				em.remove(u);
				em.flush();
				return true;
			} else if(u.getRol().equals(TipoUsuario.INVESTIGADOR.toString())) {
				Investigador a = (Investigador) em.createNamedQuery("Investigador.obtenerPorId_Usuario")
						.setParameter("id_usuario", id)
						.getResultList().get(0);
				em.remove(a);
				em.remove(u);
				em.flush();
				return true;
			} else if(u.getRol().equals(TipoUsuario.AFICIONADO.toString())){
				Aficionado a = (Aficionado) em.createNamedQuery("Aficionado.obtenerPorId_Usuario")
						.setParameter("id_usuario", id)
						.getResultList().get(0);
				em.remove(a);
				em.remove(u);
				em.flush();
				return true;
			} else {
				return false;
			}
			 */
			u.setHabilitado("NO");
			em.merge(u);
			em.flush();
			return true;

		}catch(PersistenceException e){
			throw new ServiciosException("No se pudo borrar el usuario");
		}
	}


	
	public boolean modificarAdministrador(Usuario u, String domicilio, int documento, int telefono, String ciudad) throws ServiciosException {
		try {
			boolean noHayResultados = em.createNamedQuery("Administrador.obtenerPorId_Usuario")
					.setParameter("id_usuario", u.getId_usuario())
					.getResultList().isEmpty();
			if(noHayResultados) {
				return false;

			} else {
				Administrador a = (Administrador) em.createNamedQuery("Administrador.obtenerPorId_Usuario")
						.setParameter("id_usuario", u.getId_usuario())
						.getResultList().get(0);
				a.setCiudad(ciudad);
				a.setDocumento(documento);
				a.setTelefono(telefono);
				a.setDomicilio(domicilio);
				a.setNombre(u.getNombre());
				a.setApellido(u.getApellido());
				a.setMail(u.getMail());
				em.merge(a);
				//em.merge(a.getUsuario());
				em.flush();
				return true;
			}

		} catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el Administrador");
		}

	}

	
	public boolean modificarInvestigador(Usuario u, String domicilio, int documento, int telefono, String ciudad) throws ServiciosException {
		try {
			boolean noHayResultados = em.createNamedQuery("Investigador.obtenerPorId_Usuario")
					.setParameter("id_usuario", u.getId_usuario())
					.getResultList().isEmpty();
			if(noHayResultados) {
				return false;

			} else {
				Investigador a = (Investigador) em.createNamedQuery("Investigador.obtenerPorId_Usuario")
						.setParameter("id_usuario", u.getId_usuario())
						.getResultList().get(0);
				a.setCiudad(ciudad);
				a.setDocumento(documento);
				a.setTelefono(telefono);
				a.setDomicilio(domicilio);
				a.setNombre(u.getNombre());
				a.setApellido(u.getApellido());
				a.setMail(u.getMail());
				em.merge(a);
				em.flush();
				return true;
			}

		} catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el Investigador");
		}
	}

	
	public boolean modificarAficionado(Usuario u, String ocupacion) throws ServiciosException {
		try {
			boolean noHayResultados = em.createNamedQuery("Aficionado.obtenerPorId_Usuario")
					.setParameter("id_usuario", u.getId_usuario())
					.getResultList().isEmpty();
			if(noHayResultados) {
				return false;

			} else {
				Aficionado a = (Aficionado) em.createNamedQuery("Aficionado.obtenerPorId_Usuario")
						.setParameter("id_usuario", u.getId_usuario())
						.getResultList().get(0);

				a.setOcupacion(ocupacion);
				a.setNombre(u.getNombre());
				a.setApellido(u.getApellido());
				a.setMail(u.getMail());
				em.merge(a);
				em.flush();
				return true;
			}

		} catch(PersistenceException e){
			throw new ServiciosException("No se pudo actualizar el Aficionado");
		}
	}

	
	public Usuario permitirAcceso(String nombreUsuario, String contrasena) throws ServiciosException {
		try {
			boolean noHayResultados = em.createNamedQuery("Usuario.login")
					.setParameter("nombre_usuario", nombreUsuario)
					.setParameter("contrasena", contrasena)
					.getResultList().isEmpty();
			if(noHayResultados) {
				return null;

			} else {
				Usuario u = (Usuario) em.createNamedQuery("Usuario.login")
						.setParameter("nombre_usuario", nombreUsuario)
						.setParameter("contrasena", contrasena)
						.getResultList().get(0);
				return u;
			}

		} catch(PersistenceException e){
			throw new ServiciosException("No se pudo iniciar sesion");
		}

	}
	
	public Administrador obtenerAdministrador(Long id_usuario) {
		Administrador a = (Administrador) em.createNamedQuery("Administrador.obtenerPorId_Usuario")
				.setParameter("id_usuario", id_usuario)
				.getResultList().get(0);	
		return a;
	}

	
	public Investigador obtenerInvestigador(Long id_usuario) {
		Investigador a = (Investigador) em.createNamedQuery("Investigador.obtenerPorId_Usuario")
				.setParameter("id_usuario", id_usuario)
				.getResultList().get(0);	
		return a;
	}

	
	public Aficionado obtenerAficionado(Long id_usuario) {
		Aficionado a = (Aficionado) em.createNamedQuery("Aficionado.obtenerPorId_Usuario")
				.setParameter("id_usuario", id_usuario)
				.getResultList().get(0);	
		return a;
	}

}
