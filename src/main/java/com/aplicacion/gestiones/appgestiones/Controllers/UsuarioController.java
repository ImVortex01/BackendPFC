package com.aplicacion.gestiones.appgestiones.Controllers;

import com.aplicacion.gestiones.appgestiones.Model.Usuario;
import com.aplicacion.gestiones.appgestiones.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la gestión de Usuarios conm operaciones CRUD.
 */
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    /**
     * Crear un nuevo Usuario
     */
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Obtener Usuario por su ID.
     */
    @GetMapping("/{id}")
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    /**
     * Obtener una lista con todos los Usuarios.
     */
    @GetMapping
    public List<Usuario> obtenerTodosUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    /**
     * Actualizar los datos de los usuarios por ID.
     */
    @PutMapping("/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario != null) {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreoElectronico(usuarioActualizado.getCorreoElectronico());
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    /**
     * Eliminar Usuarios por ID
     */
    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioRepository.deleteById(id);
    }


    /**
     * Verificar si el usuario ya existe.
     */
    @GetMapping("/verificar")
    public boolean verificarUsuario(@RequestParam String email, @RequestParam String password) {
        Usuario usuario = usuarioRepository.findByCorreoElectronicoAndPassword(email, password);
        return usuario != null;
    }
}