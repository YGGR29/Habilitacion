package com.example.demo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.CascadeType;

public class Clase implements Serializable {
	@Id
	@SequenceGenerator(name = "seq_clase_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_clase_id")
	private Integer claseId;
	private String descripction;
	private String nuuid;
	
	@JsonIgnore
	@OneToMany(mappedBy = "assignedClass", cascade = CascadeType.ALL)
	private List<Jugador> classMembers = new ArrayList<>();

	public List<Jugador> getJugadores() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
