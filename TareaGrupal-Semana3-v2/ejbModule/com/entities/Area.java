package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Area
 *
 */
@Entity
@NamedQuery(name="Area.obtenerTodos", query="SELECT a FROM Area a")
public class Area implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_area;
	
	@Column (name = "NOMBRE", length = 30)
	private String nombre;
	
	@OneToMany
	private List<Salon> salones = new ArrayList<>();
	
	public Area() {
		super();
	}

	public Long getId_area() {
		return id_area;
	}

	public void setId_area(Long id_area) {
		this.id_area = id_area;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Salon> getSalones() {
		return salones;
	}

	public void setSalones(List<Salon> salones) {
		this.salones = salones;
	} 
	
   
}
