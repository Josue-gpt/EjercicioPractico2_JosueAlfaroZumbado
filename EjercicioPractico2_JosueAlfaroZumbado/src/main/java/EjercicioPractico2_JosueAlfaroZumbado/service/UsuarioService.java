/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.service;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Usuario;
import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuario(Usuario usuario);

    void save(Usuario usuario);

    void delete(Usuario usuario);

    Usuario findByEmail(String email);

    List<Usuario> findByRol(String rol);
}
