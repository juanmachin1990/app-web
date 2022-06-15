package com.entities;

import com.entities.Usuario;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrador
 *
 */
@Entity

public class Administrador extends Usuario {
	
	
	private static final long serialVersionUID = 1L;	
	
	@Column(name="DOCUMENTO")
	private int documento;
	@Column(name="DOMICILIO",length=50)
	private String domicilio;
	@Column(name="TELEFONO",length=50)
	private int telefono;
	@Column(name="CIUDAD",length=50)
	private String ciudad;
	
	
	public Administrador() {
		super();
	}
	
	public Administrador(int documento, String domicilio, int telefono, String ciudad, Usuario u) {
		super(u);
		this.documento = documento;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.ciudad = ciudad;
		
	}


	
	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Administrador [id_administrador=" + super.getId_usuario() + ", documento=" + documento + ", domicilio="
				+ domicilio + ", telefono=" + telefono + "]";
	} 
	
	
	
   
}
