package com.entities;

import com.entities.Usuario;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Aficionado
 *
 */
@Entity

public class Aficionado extends Usuario{

	
	private static final long serialVersionUID = 1L;	
	
	@Column(name="OCUPACION",length=50)
	private String ocupacion;
	
	public Aficionado() {
		super();
	}

	
	public Aficionado(String ocupacion, Usuario usuario) {
		super(usuario);
		this.ocupacion = ocupacion;
		
	}


	public String getOcupacion() {
		return ocupacion;
	}


	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	@Override
	public String toString() {
		return "Aficionado [id_usuario=" + super.getId_usuario() + ", ocupacion=" + ocupacion + "]";
	} 
	
	
	
   
}
