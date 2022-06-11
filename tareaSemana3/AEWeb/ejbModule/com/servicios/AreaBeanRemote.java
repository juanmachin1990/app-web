package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.exception.ServiciosException;

@Remote
public interface AreaBeanRemote {
	
	 void crearArea(Area area) throws ServiciosException;
	 void asignarSalon(Long id_salon, Long id_area) throws ServiciosException;
	 void actualizarArea (Area area) throws ServiciosException;
	 void borrar (Long id_area) throws ServiciosException;
	 List <Area> obtenerTodos();

}
