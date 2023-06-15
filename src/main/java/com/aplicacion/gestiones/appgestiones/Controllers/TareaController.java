package com.aplicacion.gestiones.appgestiones.Controllers;

import com.aplicacion.gestiones.appgestiones.Model.Proyecto;
import com.aplicacion.gestiones.appgestiones.Model.Tarea;
import com.aplicacion.gestiones.appgestiones.Repository.ProyectoRepository;
import com.aplicacion.gestiones.appgestiones.Repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de Tareas conm operaciones CRUD.
 */
@RestController
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    /**
     * Creacion de Tareas
     */
    @PostMapping
    public List<Tarea> crearTarea(@RequestBody Tarea tarea, @RequestParam("proyecto") String proyectoNombre) {
        Proyecto proyecto = proyectoRepository.findByNombre(proyectoNombre);
        tarea.setProyecto(proyecto);
        tareaRepository.save(tarea);
        return obtenerTareasPorProyecto(proyectoNombre);
    }

    /**
     * Obtener tarea por ID
     */
    @GetMapping("/{id}")
    public Tarea obtenerTarea(@PathVariable Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    /**
     * Actualizar tarea por su ID
     */
    @PutMapping("/{id}")
    public Tarea actualizarTarea(@PathVariable Long id, @RequestBody Tarea tareaActualizada) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea != null) {
            tarea.setNombre(tareaActualizada.getNombre());
            return tareaRepository.save(tarea);
        }
        return null;
    }

    /**
     * Obtener las tareas asignadas a un proyecto
     */
    @GetMapping
    public List<Tarea> obtenerTareasPorProyecto(@RequestParam("proyecto") String proyecto) {
        Proyecto proyectoObjeto = proyectoRepository.findByNombre(proyecto);
        List<Tarea> tareas = tareaRepository.findByProyecto(proyectoObjeto);
        return tareas;
    }

    /**
     * Eliminar tarea por su ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTarea(@PathVariable Long id) {
        try {
            tareaRepository.deleteById(id);
            return ResponseEntity.ok("Tarea eliminada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la tarea");
        }
    }

}
