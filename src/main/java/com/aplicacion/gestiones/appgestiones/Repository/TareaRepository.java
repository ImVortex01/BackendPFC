package com.aplicacion.gestiones.appgestiones.Repository;

import com.aplicacion.gestiones.appgestiones.Model.Proyecto;
import com.aplicacion.gestiones.appgestiones.Model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findByProyecto(Proyecto proyecto);
}

