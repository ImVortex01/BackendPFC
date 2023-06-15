package com.aplicacion.gestiones.appgestiones.Model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase Proyecto donde se definen sus propiedades , la anotacion
 * @Data proporciona tanto los Getters , Setters , toString y otras anotaciones en una sola
 */
@Entity
@Table(name = "proyectos")
@Data
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

}