package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import EjercicioPractico2_JosueAlfaroZumbado.service.EventoService;
import EjercicioPractico2_JosueAlfaroZumbado.service.UsuarioService;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String consultas(Model model) {
        model.addAttribute("eventos", null);
        model.addAttribute("usuarios", null);
        model.addAttribute("total", null);
        return "consultas";
    }

    // 🔹 Eventos activos
    @GetMapping("/activos")
    public String activos(Model model) {
        model.addAttribute("eventos", eventoService.eventosActivos());
        model.addAttribute("usuarios", null);
        model.addAttribute("total", null);
        return "consultas";
    }

    // 🔹 Buscar por nombre
    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre, Model model) {
        model.addAttribute("eventos", eventoService.buscarPorNombre(nombre));
        model.addAttribute("usuarios", null);
        model.addAttribute("total", null);
        return "consultas";
    }

    // 🔹 Contar eventos activos
    @GetMapping("/conteo")
    public String conteo(Model model) {
        model.addAttribute("total", eventoService.contarActivos());
        model.addAttribute("eventos", null);
        model.addAttribute("usuarios", null);
        return "consultas";
    }

    // 🔹 Usuarios por rol
    @GetMapping("/usuarios")
    public String usuarios(@RequestParam String rol, Model model) {
        model.addAttribute("usuarios", usuarioService.findByRol(rol));
        model.addAttribute("eventos", null);
        model.addAttribute("total", null);
        return "consultas";
    }
}