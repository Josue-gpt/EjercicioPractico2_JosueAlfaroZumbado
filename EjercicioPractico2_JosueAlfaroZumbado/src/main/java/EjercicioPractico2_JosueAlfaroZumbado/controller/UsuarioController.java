/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Usuario;
import EjercicioPractico2_JosueAlfaroZumbado.service.UsuarioService;
import EjercicioPractico2_JosueAlfaroZumbado.service.RolService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RolService rolService;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("usuarios", usuarioService.getUsuarios());
        return "usuario/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("roles", rolService.getRoles());
        return "usuario/form";
    }

    @PostMapping("/guardar")
    public String guardar(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        model.addAttribute("roles", rolService.getRoles());
        return "usuario/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Usuario usuario) {
        usuarioService.delete(usuario);
        return "redirect:/usuario/lista";
    }

    @GetMapping("/detalle/{id}")
    public String detalle(Usuario usuario, Model model) {
        usuario = usuarioService.getUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "usuario/detalle";
    }
}
