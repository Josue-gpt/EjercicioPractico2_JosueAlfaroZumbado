/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.service;

import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;
import java.util.Date;
import java.util.List;

public interface EventoService {

    List<Evento> getEventos();

    Evento getEvento(Evento evento);

    void save(Evento evento);

    void delete(Evento evento);

    List<Evento> eventosActivos();

    List<Evento> eventosPorFechas(Date inicio, Date fin);

    List<Evento> buscarPorNombre(String nombre);

    Long contarActivos();
}
