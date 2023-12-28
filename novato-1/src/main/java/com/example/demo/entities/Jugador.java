package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import lombok.Data;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GenerationType;

@Entity
@Data

public class Jugador implements Serializable {
	@Id
	
		@SequenceGenerator(name="jugador_sequence_genrator", allocationSize = 5) 
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jugador_sequence_generator")
	
private Integer id;
	private String nombre;
	private Date  fecha_nacimiento;
	private String descripcion;
	private String email;
	
	
	@ManyToOne
	@JoinColumn(name="fk_clase_id")
	private Clase Class;
	
	private String genero;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_id")
	private Rango Rank;
	
	private String nuuid;
	
	@ManyToMany
	@JoinTable(
			name = "jugador_habilidad", joinColumns = @JoinColumn(name = "fk_jugador_id"), inverseJoinColumns = @JoinColumn(name = "fk_habilidad_id")
			
			)
	
	private List<Habilidad> habilidades = new ArrayList<>();
	
	
	@JsonIgnore
	private String unusedField;


	public String getNuuid() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setNuuid(Object nuuid2) {
		// TODO Auto-generated method stub
		
	}


	public Object getRango() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setRango(Object rango) {
		// TODO Auto-generated method stub
		
	}


	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setNombre(Object nombre2) {
		// TODO Auto-generated method stub
		
	}


	public Object getFechaNacimiento() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setFechaNacimiento(Object fechaNacimiento) {
		// TODO Auto-generated method stub
		
	}


	public Object getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setDescripcion(Object descripcion2) {
		// TODO Auto-generated method stub
		
	}


	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}


	public void setClase(java.lang.Class<? extends Jugador> class2) {
		// TODO Auto-generated method stub
		
	}


	public Object getGenero() {
		// TODO Auto-generated method stub
		return null;
	}


	public void setGenero(Object genero2) {
		// TODO Auto-generated method stub
		
	}


	public List<Habilidad> getHabilidades() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	

}
