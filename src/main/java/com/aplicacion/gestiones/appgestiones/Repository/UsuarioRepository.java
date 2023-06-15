package com.aplicacion.gestiones.appgestiones.Repository;

import com.aplicacion.gestiones.appgestiones.Model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
    Usuario findByCorreoElectronicoAndPassword(String correoElectronico, String password);
}
