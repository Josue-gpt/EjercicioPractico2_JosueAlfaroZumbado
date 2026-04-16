/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;
import EjercicioPractico2_JosueAlfaroZumbado.service.EventoService;

import java.util.Date;

@Controller
@RequestMapping("/evento")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    @GetMapping("/lista")
    public String lista(Model model) {
        model.addAttribute("eventos", eventoService.getEventos());
        return "evento/lista";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("evento", new Evento());
        return "evento/form";
    }

    @PostMapping("/guardar")
    public String guardar(Evento evento) {
        eventoService.save(evento);
        return "redirect:/evento/lista";
    }

    @GetMapping("/editar/{id}")
    public String editar(Evento evento, Model model) {
        evento = eventoService.getEvento(evento);
        model.addAttribute("evento", evento);
        return "evento/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Evento evento) {
        eventoService.delete(evento);
        return "redirect:/evento/lista";
    }
}
