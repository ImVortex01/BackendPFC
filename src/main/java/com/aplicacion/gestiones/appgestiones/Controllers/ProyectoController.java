package com.aplicacion.gestiones.appgestiones.Controllers;

import com.aplicacion.gestiones.appgestiones.Model.Proyecto;
import com.aplicacion.gestiones.appgestiones.Model.Tarea;
import com.aplicacion.gestiones.appgestiones.Repository.ProyectoRepository;
import com.aplicacion.gestiones.appgestiones.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para la gestión de proyectos conm operaciones CRUD.
 */

@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private TareaRepository tareaRepository;

    /**
     * Crear un nuevo Proyecto.
     */
    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }


    /**
     * Obtener un Proyecto por su ID.
     */
    @GetMapping("/{id}")
    public Proyecto obtenerProyecto(@PathVariable Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    /**
     * Obtener una lista con todos los Proyectos
     */
    @GetMapping
    public List<Proyecto> obtenerTodosProyectos() {
        return (List<Proyecto>) proyectoRepository.findAll();
    }

    /**
     * Obtener un Proyecto por su Nombre.
     */
    @GetMapping(params = "nombre")
    public Proyecto obtenerProyectoPorNombre(@RequestParam String nombre) {
        return proyectoRepository.findByNombre(nombre);
    }


    /**
     * Actualizar los datos del Proyecto con su ID.
     */
    @PutMapping("/{id}")
    public Proyecto actualizarProyecto(@PathVariable Long id, @RequestBody Proyecto proyectoActualizado) {
        Proyecto proyecto = proyectoRepository.findById(id).orElse(null);
        if (proyecto != null) {
            proyecto.setNombre(proyectoActualizado.getNombre());
            return proyectoRepository.save(proyecto);
        }
        return null;
    }

    /**
     * Eliminar un proyecto por su Nombre.
     */
    @DeleteMapping
    public void eliminarProyectoPorNombre(@RequestParam String nombre) {
        Proyecto proyecto = proyectoRepository.findByNombre(nombre);
        if (proyecto != null) {
            List<Tarea> tareas = tareaRepository.findByProyecto(proyecto);
            for (Tarea tarea : tareas) {
                tareaRepository.delete(tarea);
            }
            proyectoRepository.delete(proyecto);
        }
    }


}
