package com.aplicacion.gestiones.appgestiones.Model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase Usuario donde se definen sus propiedades , la anotacion
 * @Data proporciona tanto los Getters , Setters , toString y otras anotaciones en una sola
 */
@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String correoElectronico;

}
