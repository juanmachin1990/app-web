package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.entities.Material;
import com.entities.Salon;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class SalonBean
 */
@Stateless
@LocalBean
public class SalonBean implements SalonBeanRemote {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public SalonBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crearSalon(Salon salon) throws ServiciosException {
		try{
			em.persist(salon);
			em.flush();
			System.out.println("Salon creado con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el salon");
		}	
		
	}

	@Override
	public void asignarMaterial(Long id_material, Long id_salon) throws ServiciosException {
		try {
			Salon salon = em.find(Salon.class, id_salon);
			Material material = em.find(Material.class, id_material);
			salon.getMateriales().add(material);
			em.persist(salon);
			em.flush();
			System.out.println("Material " + material.getNombre() + "asignado con exito" );
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo asignar el material al salon");
		}
		
	}

	@Override
	public void actualizarSalon(Salon salon) throws ServiciosException {
		try{
			em.merge(salon);
			em.flush();	
			System.out.println("Salon actualizado con exito");
		}catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el salon");
		}
		
	}

	@Override
	public void borrar(Long id_salon) throws ServiciosException {
		try {
			Salon salon = em.find(Salon.class, id_salon);
			em.remove(salon);
			em.flush();
			System.out.println("Salon eliminado con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el salon");
		}
		
		
	}

	@Override
	public List<Salon> obtenerTodos() {
		TypedQuery<Salon> query = em.createNamedQuery("Salon.obtenerTodos",Salon.class);
		return query.getResultList();
	}

}
