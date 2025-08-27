package com.example.alumnos;

import com.example.alumnos.model.Alumno;
import com.example.alumnos.repository.AlumnoRepository;
import com.example.alumnos.service.AlumnoService;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class AlumnoServiceTest {

    @Test
    public void testGuardarAlumnoOk() {
        AlumnoRepository repo = new AlumnoRepository();
        AlumnoService service = new AlumnoService(repo);

        Alumno alumno = new Alumno();
        alumno.setId("1");
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setEstado("activo");
        alumno.setEdad(20);

        StepVerifier.create(service.registrarAlumno(alumno))
                .verifyComplete();

        StepVerifier.create(service.obtenerAlumnosActivos())
                .expectNext(alumno)
                .verifyComplete();
    }

    @Test
    public void testGuardarAlumnoDuplicado() {
        AlumnoRepository repo = new AlumnoRepository();
        AlumnoService service = new AlumnoService(repo);

        Alumno alumno = new Alumno();
        alumno.setId("1");
        alumno.setNombre("Juan");
        alumno.setApellido("Perez");
        alumno.setEstado("activo");
        alumno.setEdad(20);

        service.registrarAlumno(alumno).block();

        StepVerifier.create(service.registrarAlumno(alumno))
                .expectErrorMatches(err -> err.getMessage().contains("ID ya existe"))
                .verify();
    }
}
