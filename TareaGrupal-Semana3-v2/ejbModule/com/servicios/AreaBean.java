package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Salon;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class AreaBean
 */
@Stateless
@LocalBean
public class AreaBean implements AreaBeanRemote {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public AreaBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crearArea(Area area) throws ServiciosException {
		try{
			em.persist(area);
			em.flush();
			System.out.println("Area creada con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el area");
		}	
		
	}

	@Override
	public void asignarSalon(Long id_salon, Long id_area) throws ServiciosException {
		try {
			Area area = em.find(Area.class, id_area);
			Salon salon = em.find(Salon.class, id_salon);
			area.getSalones().add(salon);
			em.persist(area);
			em.flush();
			System.out.println("Salon " + salon.getNombre() + "asignado con exito" );
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el salon al area");
		}
	}

	@Override
	public void actualizarArea(Area area) throws ServiciosException {
			try {
				em.merge(area);
				em.flush();	
				System.out.println("Area actualizada con exito");
			}catch (PersistenceException e) {
				throw new ServiciosException("No se pudo actualizar el area");
			}
			
		}

	@Override
	public void borrar(Long id_area) throws ServiciosException {
		try {
			Area area = em.find(Area.class, id_area);
			em.remove(area);
			em.flush();
			System.out.println("Area eliminada con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el area");
		}
		
	}

	@Override
	public List<Area> obtenerTodos() {
		TypedQuery<Area> query = em.createNamedQuery("Area.obtenerTodos",Area.class);
		return query.getResultList();
	}

}
