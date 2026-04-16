/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long> {

    // Para Security
    Optional<Rol> findByNombre(String nombre);
}
