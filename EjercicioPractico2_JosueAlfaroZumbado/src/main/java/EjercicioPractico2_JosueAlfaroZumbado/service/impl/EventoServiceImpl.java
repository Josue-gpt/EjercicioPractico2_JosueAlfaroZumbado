/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;
import EjercicioPractico2_JosueAlfaroZumbado.repository.EventoRepository;
import EjercicioPractico2_JosueAlfaroZumbado.service.EventoService;

import java.util.Date;
import java.util.List;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public List<Evento> getEventos() {
        return eventoRepository.findAll();
    }

    @Override
    public Evento getEvento(Evento evento) {
        return eventoRepository.findById(evento.getId()).orElse(null);
    }

    @Override
    public void save(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public void delete(Evento evento) {
        eventoRepository.delete(evento);
    }

    @Override
    public List<Evento> eventosActivos() {
        return eventoRepository.findByActivo(true);
    }

    @Override
    public List<Evento> eventosPorFechas(Date inicio, Date fin) {
        return eventoRepository.findByFechaBetween(inicio, fin);
    }

    @Override
    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Long contarActivos() {
        return eventoRepository.contarActivos();
    }
}
