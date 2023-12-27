package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Jugador;


public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
	
/*
    @Modifying
    @Transactional
    @Query("UPDATE Jugador j SET j.habilidades = CONCAT(j.habilidades, :habilidadNuuid) WHERE j.nuuid = :nuuid")
    void agregarHabilidad(String nuuid, String habilidadNuuid);
    Optional<Jugador> findById(Long id);
    */
    
}