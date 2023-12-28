package com.example.demo.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.GenerationType;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rango implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name="seq_rango_id", allocationSize = 2)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_rango_id")
	private Integer RangoId;
	private String descripcion;
	private String nuuid;
}
