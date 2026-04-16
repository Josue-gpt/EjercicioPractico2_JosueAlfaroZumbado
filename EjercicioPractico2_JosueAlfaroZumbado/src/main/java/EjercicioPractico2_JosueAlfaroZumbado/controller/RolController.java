/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Rol;
import EjercicioPractico2_JosueAlfaroZumbado.service.RolService;

@Controller
@RequestMapping("/rol")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("roles", rolService.getRoles());
        return "rol/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("rol", new Rol());
        return "rol/form";
    }

    @PostMapping("/guardar")
    public String guardar(Rol rol) {
        rolService.save(rol);
        return "redirect:/rol/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(Rol rol, Model model) {
        rol = rolService.getRol(rol);
        model.addAttribute("rol", rol);
        return "rol/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Rol rol) {
        try {
            rolService.delete(rol);
        } catch (Exception e) {
            // 🔥 Manejo FK
        }
        return "redirect:/rol/lista";
    }
}
