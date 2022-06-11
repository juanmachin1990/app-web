package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.entities.Salon;
import com.entities.TipoSalon;
import com.exception.ServiciosException;

@Remote
public interface SalonBeanRemote {
	
	void crearSalon(Salon salon) throws ServiciosException;
	void asignarMaterial(Long id_material, Long id_salon) throws ServiciosException;
	void actualizarSalon (Salon salon) throws ServiciosException;
	void borrar (Long id_salon) throws ServiciosException;
	List <Salon> obtenerTodos();

}
