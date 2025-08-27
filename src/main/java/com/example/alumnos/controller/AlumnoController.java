package com.example.alumnos.controller;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.service.AlumnoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {
    private final AlumnoService service;

    public AlumnoController(AlumnoService service) {
        this.service = service;
    }

    @PostMapping
    public Mono<Void> registrar(@RequestBody Alumno alumno) {
        return service.registrarAlumno(alumno);
    }

    @GetMapping("/activos")
    public Flux<Alumno> listarActivos() {
        return service.obtenerAlumnosActivos();
    }

}
