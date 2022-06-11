package com.servicios;

import java.util.List;

import javax.ejb.Remote;
import javax.persistence.Column;

import com.entities.Material;
import com.exception.ServiciosException;

@Remote
public interface MaterialBeanRemote {
	

	 void crearMaterial(Material material) throws ServiciosException;
	 void actualizarMaterial (Material material) throws ServiciosException;
	 void borrar (Long id_material) throws ServiciosException;
	 List <Material> obtenerTodos();

}

