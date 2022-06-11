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
import com.exception.ServiciosException;

/**
 * Session Bean implementation class MaterialBean
 */
@Stateless
@LocalBean
public class MaterialBean implements MaterialBeanRemote {
	
	@PersistenceContext
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public MaterialBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void crearMaterial(Material material) throws ServiciosException {
		try{
			em.persist(material);
			em.flush();
			System.out.println("Material creado con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo crear el material");
		}	
		
	}

	@Override
	public void actualizarMaterial(Material material) throws ServiciosException {
		try{
			em.merge(material);
			em.flush();	
			System.out.println("Material actualizada con exito");
		}catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el material");
		}
	
	}

	@Override
	public void borrar(Long id_material) throws ServiciosException {
		try {
			Material material = em.find(Material.class, id_material);
			em.remove(material);
			em.flush();
			System.out.println("Material eliminado con exito");
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo borrar el material");
		}
		
	}

	@Override
	public List<Material> obtenerTodos() {
		TypedQuery<Material> query = em.createNamedQuery("Material.obtenerTodos",Material.class);
		return query.getResultList();
	}

}
