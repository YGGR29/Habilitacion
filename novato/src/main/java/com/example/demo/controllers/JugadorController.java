package com.example.demo.controllers;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.Leveling.Entities.Habilidad;
import com.example.demo.entities.Jugador;
import com.example.demo.repositories.JugadorRepository;
import com.example.demo.services.JugadorService;

import repository.jugadorRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    private JugadorService jugadorService;

	@Autowired
    public JugadorController(JugadorService jugadorService) {
        this.jugadorService = jugadorService;
    }
	
	 @PostMapping("/crear")
		public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador nuevoJugador) {
		    java.util.Optional<com.example.Leveling.Entities.Jugador> jugadorExistente = jugadorRepository.findById(nuevoJugador.getEmail());

		    if (jugadorExistente != null) {
		        return ResponseEntity.badRequest().body(null);
		    }

		    Jugador jugadorCreado = jugadorRepository.saveAll(nuevoJugador);
		    return ResponseEntity.status(HttpStatus.CREATED).body(jugadorCreado);
		}
	 
	 @GetMapping("/lista")
		public ResponseEntity<List<com.example.Leveling.Entities.Jugador>> listarJugadores() {
		    List<com.example.Leveling.Entities.Jugador> jugadores;
			try {
				jugadores = jugadorRepository.findAll();
			} catch (Exception e) {
			
				e.printStackTrace();
			}

		    List<Jugador> entrenadores;
			if (entrenadores.isEmpty()) {
		        return ResponseEntity.noContent().build();
		    }

		    return ResponseEntity.ok(jugadores);
		}

    @PostMapping("/jugadores/login")
    public ResponseEntity<Object> login(@RequestParam String nombre, @RequestParam String nuuid) {
    	  Object email;
		Jugador jugador = jugadorRepository.findById(email);

  	    if (jugador == null) {
  	        return ResponseEntity.notFound().build();
  	    }

  	    Map<String, String> response = new HashMap<>();
  	    response.put("nuuid", (String) jugador.getNuuid());

  	    return ResponseEntity.ok(response);
  	}
    @GetMapping("/{clase}")
	public ResponseEntity<List<Jugador>> listarJugadorPorClase(@PathVariable("clase") String claseNuuid) {
	    Clase clase = claserepository.findByClase(claseNuuid);

	    if (clase == null) {
	        return ResponseEntity.notFound().build();
	    }

	    List<Jugador> pjugadores = clase.getJugadores();

	    if (pokemones.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    return ResponseEntity.ok(jugadores);
	}

    @PostMapping
    public ResponseEntity<Jugador> registrarJugador(@RequestBody Jugador nuevoJugador) {
        if (nuevoJugador.getNuuid() != null && jugadorRepository.findByNuuid(nuevoJugador.getNuuid()) != null) {
            return ResponseEntity.badRequest().body(null); 
        }

        Jugador jugadorGuardado = jugadorRepository.save(nuevoJugador);
        return ResponseEntity.ok(jugadorGuardado);
    }

    @GetMapping("/{nuuid}/habilidades")
	 public ResponseEntity<List<Jugador>> listarHabilidadesDeJugador(@PathVariable("nuuid") String nuuid) {
	     Jugador jugador = jugadorRepository.findByNuuid(nuuid);

	     if (jugador == null) {
	         return ResponseEntity.notFound().build();
	     }

	     List<Habilidad> habilidades = jugador.getHabilidades();

	     return ResponseEntity.ok(habilidades);
	 }

     @PostMapping("/{nuuid}/habilidades/{nuuid}")
	 public ResponseEntity<String> agregarHabilidadAJugador(
	         @PathVariable("nuuid") String jugadorNuuid,
	         @PathVariable("nuuid") String habilidadNuuid) {

	     Jugador jugador = jugadorRepository.findByNuuid(jugadorNuuid);
	     Habilidad habilidad = habilidadRepository.findByNuuid(habilidadNuuid);

	     if (jugador == null || habilidad == null) {
	         return ResponseEntity.notFound().build();
	     }

	     List<Habilidad> habilidadesJugador = jugador.getHabilidades();

	     boolean yaAsociado = HabilidadesJugador.contains(habilidad);

	     if (yaAsociado) {
	         return ResponseEntity.badRequest().body("La habilidad ya fue registrada al jugador");
	     }

	     habilidadesJugadordor.add(habilidad);
	     jugadorRepository.save(jugador);

	     return ResponseEntity.ok().build();
	 }
     
     @PutMapping("/{nuuid}")
     public <S> ResponseEntity<Jugador> actualizarJugadorPorNuuid(@PathVariable String nuuid, @RequestBody Jugador jugadorActualizado) {
         try {
			Optional<Jugador> optionalJugador = jugadorRepository.findByNuuid(nuuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
         java.util.Optional<com.example.Leveling.Entities.Jugador> optionalJugador;
		if (optionalJugador.isPresent()) {
             com.example.Leveling.Entities.Jugador jugador = optionalJugador.get();
 
             jugador.setNombre(jugadorActualizado.getNombre());
             jugador.setFechaNacimiento(jugadorActualizado.getFechaNacimiento());
             jugador.setDescripcion(jugadorActualizado.getDescripcion());
             jugador.setEmail(jugadorActualizado.getEmail());
             jugador.setClase(jugadorActualizado.getClass());
             jugador.setGenero(jugadorActualizado.getGenero());
             jugador.setRango(jugadorActualizado.getRango());
             jugador.setNuuid(jugadorActualizado.getNuuid());
 
             Jugador jugadorGuardado = JugadorRepository.saveAll ((Iterable<S>) jugador);
 
             return ResponseEntity.ok(jugadorGuardado);
         } else {
             return ResponseEntity.notFound().build();
         }
     }

}