package com.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Salon
 *
 */
@Entity
@NamedQuery(name="Salon.obtenerTodos", query="SELECT s FROM Salon s")
public class Salon implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_salon;
	
	@Column(name="NOMBRE", length=50)
	private String nombre;
	
	@Column(name="CAPMAXIMA")
	private int capMaxima;
	
	@Column(name = "ESDEPRACTICA", length=1)
	private boolean esDePractica; //hacer que guarde true o false
	
	@Enumerated(EnumType.STRING)
	private TipoSalon tipoSalon;
	
	
	@OneToMany
	private List<Material> materiales = new ArrayList<>();
	public Salon() {
		super();
	}
	public Long getId_salon() {
		return id_salon;
	}
	public void setId_salon(Long id_salon) {
		this.id_salon = id_salon;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapMaxima() {
		return capMaxima;
	}
	public void setCapMaxima(int capMaxima) {
		this.capMaxima = capMaxima;
	}
	public boolean isEsDePractica() {
		return esDePractica;
	}
	public void setEsDePractica(boolean esDePractica) {
		this.esDePractica = esDePractica;
	}
	public TipoSalon getTipoSalon() {
		return tipoSalon;
	}
	public void setTipoSalon(TipoSalon tipoSalon) {
		this.tipoSalon = tipoSalon;
	}
	public List<Material> getMateriales() {
		return materiales;
	}
	public void setMateriales(List<Material> materiales) {
		this.materiales = materiales;
	} 
	
   
}
