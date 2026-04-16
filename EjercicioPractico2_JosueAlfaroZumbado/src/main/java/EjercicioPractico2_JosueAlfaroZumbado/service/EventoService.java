package EjercicioPractico2_JosueAlfaroZumbado.service;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;
import java.util.List;

public interface EventoService {

    List<Evento> getEventos();

    Evento getEvento(Evento evento);

    void save(Evento evento);

    void delete(Evento evento);

    // 🔹 Eventos activos
    List<Evento> eventosActivos();

    // 🔹 Buscar por nombre
    List<Evento> buscarPorNombre(String nombre);

    // 🔹 Contar eventos activos
    Long contarActivos();
}