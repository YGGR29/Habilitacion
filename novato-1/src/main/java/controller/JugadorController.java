package controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import com.example.demo.repository.ClaseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.*;
import com.example.demo.repository.*;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private HabilidadRepository habilidadRepository;

    @PostMapping("/crear")
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador nuevoJugador) {
    	Jugador jugadorExistente = jugadorRepository.findByEmail(nuevoJugador.getEmail());


        if (jugadorExistente != null) {
            return ResponseEntity.badRequest().body(null);
        }

        Jugador jugadorCreado = jugadorRepository.save(nuevoJugador);
        return ResponseEntity.status(HttpStatus.CREATED).body(jugadorCreado);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Jugador>> listarJugadores() {
        List<Jugador> jugadores = jugadorRepository.findAll();

        if (jugadores.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(jugadores);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> obtenerNUUIDPorEmail(@RequestParam String email) {
        Jugador jugador = jugadorRepository.findAll(email);

        if (jugador == null) {
            return ResponseEntity.notFound().build();
        }

        Map<String, String> response = new HashMap<>();
        String put = response.put("nuuid", jugador.getNuuid());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{clase}")
    public ResponseEntity<List<Jugador>> listarJugadorPorClase(@PathVariable("clase") String claseNuuid) {
        Object claseRepository = null;
        Clase clase = ((ClaseRepository) claseRepository).findByClase(claseNuuid);


        if (clase == null) {
            return ResponseEntity.notFound().build();
        }

        List<Jugador> jugadores = clase.getJugadores();

        if (jugadores.isEmpty()) {
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
    public ResponseEntity<List<Habilidad>> listarHabilidadesDeJugador(@PathVariable("nuuid") String nuuid) {
        Jugador jugador = (Jugador) jugadorRepository.findByNuuid(nuuid);

        if (jugador == null) {
            return ResponseEntity.notFound().build();
        }

        List<Habilidad> habilidades = jugador.getHabilidades();

        return ResponseEntity.ok(habilidades);
    }

    @PostMapping("/{nuuid}/habilidades/{habilidadNuuid}")
    public ResponseEntity<String> agregarHabilidadAJugador(
            @PathVariable("nuuid") String jugadorNuuid,
            @PathVariable("habilidadNuuid") String habilidadNuuid) {

        Optional<Jugador> jugador = Optional.ofNullable(jugadorRepository.findByNuuid(jugadorNuuid));
        Habilidad habilidad = habilidadRepository.findAllById(habilidadNuuid);

        if (jugador == null || habilidad == null) {
            return ResponseEntity.notFound().build();
        }

        String nuuid = null;
		Optional<Jugador> optionalJugador = Optional.ofNullable(jugadorRepository.findByNuuid(nuuid));
        Jugador jugador1 = optionalJugador.orElse(null);

        if (jugador1 != null) {
            List<Habilidad> habilidadesJugador = jugador1.getHabilidades();
        } else {
            return ResponseEntity.notFound().build();
        }


        List<Jugador> habilidadesJugador = null;
		boolean yaAsociado = habilidadesJugador.contains(habilidad);

        if (yaAsociado) {
            return ResponseEntity.badRequest().body("La habilidad ya fue registrada al jugador");
        }

        habilidadesJugador.addAll((Collection<? extends Jugador>) habilidad);
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{nuuid}")
    public ResponseEntity<Jugador> actualizarJugadorPorNuuid(@PathVariable String nuuid, @RequestBody Jugador jugadorActualizado) {
        Optional<Jugador> optionalJugador = Optional.ofNullable(jugadorRepository.findByNuuid(nuuid));

        if (optionalJugador.isPresent()) {
            Jugador jugador = optionalJugador.get();

            jugador.setNombre(jugadorActualizado.getNombre());
            jugador.setFechaNacimiento(jugadorActualizado.getFechaNacimiento());
            jugador.setDescripcion(jugadorActualizado.getDescripcion());
            jugador.setEmail(jugadorActualizado.getEmail());
            jugador.setClase(jugadorActualizado.getClass());
            jugador.setGenero(jugadorActualizado.getGenero());
            jugador.setRango(jugadorActualizado.getRango());
            jugador.setNuuid(jugadorActualizado.getNuuid());

            Jugador jugadorGuardado = jugadorRepository.save(jugador);

            return ResponseEntity.ok(jugadorGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
