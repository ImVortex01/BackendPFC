package com.aplicacion.gestiones.appgestiones.Model;

import jakarta.persistence.*;
import lombok.Data;
/**
 * Clase Tarea donde se definen sus propiedades , la anotacion
 * @Data proporciona tanto los Getters , Setters , toString y otras anotaciones en una sola
 */
@Entity
@Table(name = "tareas")
@Data
public class Tarea {
    @ManyToOne
    @JoinColumn(name = "proyecto_id", nullable = false)
    private Proyecto proyecto;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String descripcion;
}
