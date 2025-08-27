package com.example.alumnos.model;

import lombok.*;

@Data
public class Alumno {
    private String id;
    private String nombre;
    private String apellido;
    private String estado; // "activo" o "inactivo"
    private Integer edad;
}
