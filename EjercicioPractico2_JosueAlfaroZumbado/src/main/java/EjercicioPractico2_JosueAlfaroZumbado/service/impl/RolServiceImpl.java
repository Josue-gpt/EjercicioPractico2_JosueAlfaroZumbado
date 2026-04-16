/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import EjercicioPractico2_JosueAlfaroZumbado.repository.RolRepository;
import EjercicioPractico2_JosueAlfaroZumbado.service.RolService;

import java.util.List;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    @Override
    public Rol getRol(Rol rol) {
        return rolRepository.findById(rol.getId()).orElse(null);
    }

    @Override
    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(Rol rol) {
        rolRepository.delete(rol);
    }
}
