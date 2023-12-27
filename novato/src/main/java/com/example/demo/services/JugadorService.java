package com.example.demo.services;


import com.example.Leveling.Entities.Jugador;
import com.example.demo.entities.Habilidad;

import java.util.List;

public interface JugadorService {
    String login(Jugador request);
    List<Jugador> getJugadoresByClase(String clase);
    Jugador registrarJugador(com.example.demo.entities.Jugador jugador);
    List<Habilidad> getHabilidadesByJugador(String nuuid);
    void agregarHabilidad(String nuuid, String habilidadNuuid);
    Jugador actualizarJugador(Long id, com.example.demo.entities.Jugador jugador);
    String login(String nombre, String nuuid);
    List<Jugador> getJugadoresByClase1(String claseNuuid);
    Jugador registrarJugador1(Jugador jugador);
    List<String> getHabilidadesByJugador1(String nuuid);
    void agregarHabilidad1(String nuuid, String habilidadNuuid);
    Jugador actualizarJugador1(Long id, Jugador jugador);}