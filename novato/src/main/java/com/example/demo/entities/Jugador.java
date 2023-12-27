package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data

public class Jugador implements Serializable {
    @Id
	@SequenceGenerator(name="jugador_id_seq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "jugador_id_seq")
	private Integer id;
	private String nombre;
    private Date fecha_nacimiento;
	private String descripcion;
    private String email;
    @ManyToOne
	@JoinColumn(name="clase_id")
	private Clase clase;
    private String genero;
    @ManyToOne
	@JoinColumn(name="rango_id")
	private Rango rango;
    private String nuuid;
    
    @JsonIgnore
	@ManyToMany
    @JoinTable(
        name = "habilidad_jugador",
        joinColumns = @JoinColumn(name = "jugador_id"),
        inverseJoinColumns = @JoinColumn(name = "habilidad_id")
    )
    private List<Habilidad> habilidades = new ArrayList<>();

	public Object getNuuid() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getRango() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getDescripcion() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNuuid(Object nuuid2) {
		// TODO Auto-generated method stub
		
	}

	public void setDescripcion(Object descripcion2) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(Object email2) {
		// TODO Auto-generated method stub
		
	}

	public void setRango(Object rango2) {
		// TODO Auto-generated method stub
		
	}

	public Object getGenero() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setGenero(Object genero2) {
		// TODO Auto-generated method stub
		
	}

	public void setClase(Class<? extends Jugador> class1) {
		// TODO Auto-generated method stub
		
	}

	public Object getFechaNacimiento() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setFechaNacimiento(Object fechaNacimiento) {
		// TODO Auto-generated method stub
		
	}

	public Object getNombre() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNombre(Object nombre2) {
		// TODO Auto-generated method stub
		
	}
}