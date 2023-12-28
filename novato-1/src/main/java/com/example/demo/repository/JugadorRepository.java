package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Jugador;


public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

	Jugador findByNuuid(String nuuid);

	Jugador findByEmail(Object email);

	Jugador findAll(String email);

	void save(Optional<Jugador> jugador);

    
}