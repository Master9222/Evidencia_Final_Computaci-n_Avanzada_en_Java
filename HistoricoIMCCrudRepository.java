package com.imc.imc_app.persistence.crud;

import com.imc.imc_app.persistence.entity.HistoricoIMC;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional; // Asegúrate de importar Optional

@Repository
public interface HistoricoIMCCrudRepository extends CrudRepository<HistoricoIMC, Integer> {
    // Buscar todos los historiales de IMC por ID de usuario
    List<HistoricoIMC> findByUsuarioId(Integer usuarioId);

    // Buscar registros de IMC entre dos fechas
    List<HistoricoIMC> findByFechaBetween(Timestamp startDate, Timestamp endDate);

    // Contar los registros de IMC por ID de usuario
    Long countByUsuarioId(Integer usuarioId);

    // Obtener el último registro de IMC por ID de usuario
    Optional<HistoricoIMC> findTopByUsuarioIdOrderByFechaDesc(Integer usuarioId);

    // Obtener todos los registros ordenados por fecha descendente
    List<HistoricoIMC> findByOrderByFechaDesc();
}
