package com.example.alumnos.repository;

import com.example.alumnos.model.Alumno;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Repository
public class AlumnoRepository {
    private final Map<String, Alumno> data = new ConcurrentHashMap<>();

    public Mono<Void> save(Alumno alumno) {
        if (data.containsKey(alumno.getId())) {
            return Mono.error(new RuntimeException("El ID ya existe"));
        }
        data.put(alumno.getId(), alumno);
        return Mono.empty();
    }

    public Flux<Alumno> findActivos() {
        return Flux.fromIterable(data.values())
                .filter(alumno -> "activo".equalsIgnoreCase(alumno.getEstado()));
    }
}
