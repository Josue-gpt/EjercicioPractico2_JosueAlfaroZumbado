/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // 🔹 LOGIN (IMPORTANTE)
    Optional<Usuario> findByEmail(String email);

    // 🔹 CONSULTA DERIVADA
    List<Usuario> findByRolNombre(String nombreRol);

    // 🔹 JPQL
    @Query("SELECT u FROM Usuario u WHERE u.rol.nombre = :rol")
    List<Usuario> buscarPorRol(@Param("rol") String rol);
}
