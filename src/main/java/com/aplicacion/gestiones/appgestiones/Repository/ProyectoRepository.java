package com.aplicacion.gestiones.appgestiones.Repository;

import com.aplicacion.gestiones.appgestiones.Model.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {
    Proyecto findByNombre(String nombre);

}