package EjercicioPractico2_JosueAlfaroZumbado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import EjercicioPractico2_JosueAlfaroZumbado.domain.Evento;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {

    // 🔹 Eventos activos (DERIVADA)
    List<Evento> findByActivoTrue();

    // 🔹 Buscar por nombre (DERIVADA)
    List<Evento> findByNombreContainingIgnoreCase(String nombre);

    // 🔹 Contar eventos activos (JPQL)
    @Query("SELECT COUNT(e) FROM Evento e WHERE e.activo = true")
    Long contarEventosActivos();
}