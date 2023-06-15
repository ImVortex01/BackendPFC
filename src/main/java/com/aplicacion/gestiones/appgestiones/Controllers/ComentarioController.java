package com.aplicacion.gestiones.appgestiones.Controllers;

import com.aplicacion.gestiones.appgestiones.Model.Comentario;
import com.aplicacion.gestiones.appgestiones.Repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la gestión de comentarios conm operaciones CRUD.
 */
@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioRepository comentarioRepository;

    /**
     * Crea un nuevo comentario.
     */
    @PostMapping
    public Comentario crearComentario(@RequestBody Comentario comentario) {
        return comentarioRepository.save(comentario);
    }
    /**
     * Obtiene un comentario por su ID.
     */
    @GetMapping("/{id}")
    public Comentario obtenerComentario(@PathVariable Long id) {
        return comentarioRepository.findById(id).orElse(null);
    }

    /**
     * Actualiza un comentario existente.
     */
    @PutMapping("/{id}")
    public Comentario actualizarComentario(@PathVariable Long id, @RequestBody Comentario comentarioActualizado) {
        Comentario comentario = comentarioRepository.findById(id).orElse(null);
        if (comentario != null) {
            comentario.setContenido(comentarioActualizado.getContenido());
            return comentarioRepository.save(comentario);
        }
        return null;
    }

    /**
     * Elimina un comentario por su ID.
     */
    @DeleteMapping("/{id}")
    public void eliminarComentario(@PathVariable Long id) {
        comentarioRepository.deleteById(id);
    }
}
