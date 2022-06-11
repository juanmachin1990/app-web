package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Material
 *
 */
@Entity
@NamedQuery(name="Material.obtenerTodos", query="SELECT m FROM Material m")
public class Material implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_material;
	
	@Column (name = "NOMBRE", length = 30)
	private String nombre;
	
	@Column (name = "DESCRIPCION", length = 50)
	private String descripcion;
	
	public Material() {
		super();
	}

	public Long getId_material() {
		return id_material;
	}

	public void setId_material(Long id_material) {
		this.id_material = id_material;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	} 
	
   
}
