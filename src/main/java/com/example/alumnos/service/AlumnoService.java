package com.example.alumnos.service;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.repository.AlumnoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AlumnoService {

    private final AlumnoRepository repository;

    public AlumnoService(AlumnoRepository repository) {
        this.repository = repository;
    }

    public Mono<Void> registrarAlumno(Alumno alumno) {
        // Validaciones
        if (alumno.getId() == null || alumno.getId().isEmpty()) {
            return Mono.error(new RuntimeException("Id requerido"));
        }
        if (alumno.getNombre() == null || alumno.getNombre().isEmpty()) {
            return Mono.error(new RuntimeException("Nombre requerido"));
        }
        if (alumno.getEdad() == null || alumno.getEdad() <= 0) {
            return Mono.error(new RuntimeException("Edad inválida"));
        }

        return repository.save(alumno);
    }

    public Flux<Alumno> obtenerAlumnosActivos() {
        return repository.findActivos();
    }


}
