package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import EjercicioPractico2_JosueAlfaroZumbado.service.EventoService;

@Controller
@RequestMapping("/consultas")
public class ConsultasController {

    @Autowired
    private EventoService eventoService;

    @GetMapping
    public String consultas() {
        return "consultas";
    }

    @GetMapping("/activos")
    public String activos(Model model) {
        model.addAttribute("eventos", eventoService.eventosActivos());
        return "consultas";
    }

    @GetMapping("/buscar")
    public String buscar(@RequestParam String nombre, Model model) {
        model.addAttribute("eventos", eventoService.buscarPorNombre(nombre));
        return "consultas";
    }
}