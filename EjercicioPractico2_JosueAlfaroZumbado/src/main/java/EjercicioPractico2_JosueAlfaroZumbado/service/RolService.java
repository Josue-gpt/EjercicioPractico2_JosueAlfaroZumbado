/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.service;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import java.util.List;

public interface RolService {

    List<Rol> getRoles();

    Rol getRol(Rol rol);

    void save(Rol rol);

    void delete(Rol rol);
}
