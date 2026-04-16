package EjercicioPractico2_JosueAlfaroZumbado.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;
import EjercicioPractico2_JosueAlfaroZumbado.repository.EventoRepository;
import EjercicioPractico2_JosueAlfaroZumbado.service.EventoService;

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
        return eventoRepository.findByActivoTrue();
    }

    @Override
    public List<Evento> buscarPorNombre(String nombre) {
        return eventoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public Long contarActivos() {
        return eventoRepository.contarEventosActivos();
    }
}