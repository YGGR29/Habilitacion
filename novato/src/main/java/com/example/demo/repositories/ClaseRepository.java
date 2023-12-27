package com.example.demo.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Clase;

public interface ClaseRepository extends JpaRepository<Clase, Long> {
}