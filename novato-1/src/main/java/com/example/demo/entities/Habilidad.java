package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Habilidad  implements Serializable{
	
	@Id
	@SequenceGenerator(name = "seq_habilida_id", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_habilidad_id")
	private Integer HabilidadId;
	private  String nombre;
	private String descripcion;
	private String nuuid;
	
	@ManyToOne
	@JoinColumn(name = "fk_rango_id")
	private Rango rank;
	
}
