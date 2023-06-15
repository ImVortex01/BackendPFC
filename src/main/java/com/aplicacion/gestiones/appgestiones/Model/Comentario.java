package com.aplicacion.gestiones.appgestiones.Model;

import jakarta.persistence.*;
import lombok.Data;


/**
 * Clase Comentario donde se definen sus propiedades , la anotacion
 * @Data proporciona tanto los Getters , Setters , toString y otras anotaciones en una sola
 */
@Entity
@Table(name = "comentarios")
@Data
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String contenido;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tarea_id", nullable = false)
    private Tarea tarea;
}
