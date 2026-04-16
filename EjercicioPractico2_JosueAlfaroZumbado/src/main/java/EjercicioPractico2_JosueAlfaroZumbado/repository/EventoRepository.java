/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package EjercicioPractico2_JosueAlfaroZumbado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    // 🔹 DERIVADA
    List<Evento> findByActivo(Boolean activo);

    // 🔹 DERIVADA (rango de fechas)
    List<Evento> findByFechaBetween(Date inicio, Date fin);

    // 🔹 DERIVADA (like)
    List<Evento> findByNombreContainingIgnoreCase(String nombre);

    // 🔹 JPQL (contar activos)
    @Query("SELECT COUNT(e) FROM Evento e WHERE e.activo = true")
    Long contarActivos();

    // 🔹 SQL NATIVO (por si te lo piden explícito)
    @Query(value = "SELECT * FROM evento WHERE ac2vo = true", nativeQuery = true)
    List<Evento> eventosActivosSQL();
}
