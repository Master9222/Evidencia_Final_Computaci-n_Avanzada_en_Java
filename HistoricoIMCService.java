package com.imc.imc_app.domain.service;

import com.imc.imc_app.domain.dto.HistoricoIMCDTO;
import com.imc.imc_app.persistence.entity.HistoricoIMC;
import com.imc.imc_app.persistence.crud.HistoricoIMCCrudRepository;
import com.imc.imc_app.persistence.mapper.HistoricoIMCMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class HistoricoIMCService {

    private final HistoricoIMCCrudRepository historicoIMCCrudRepository;
    private final HistoricoIMCMapper historicoIMCMapper;

    @Autowired
    public HistoricoIMCService(HistoricoIMCCrudRepository historicoIMCCrudRepository, HistoricoIMCMapper historicoIMCMapper) {
        this.historicoIMCCrudRepository = historicoIMCCrudRepository;
        this.historicoIMCMapper = historicoIMCMapper;
    }

    // Obtener todos los registros de IMC
    public List<HistoricoIMCDTO> findAll() {
        return StreamSupport.stream(historicoIMCCrudRepository.findAll().spliterator(), false)
                .map(historicoIMCMapper::toHistoricoIMCDTO)
                .collect(Collectors.toList());
    }

    // Buscar un registro de IMC por ID
    public Optional<HistoricoIMCDTO> findById(Integer id) {
        return historicoIMCCrudRepository.findById(id)
                .map(historicoIMCMapper::toHistoricoIMCDTO);
    }

    // Crear un nuevo registro de IMC
    public HistoricoIMCDTO create(HistoricoIMCDTO historicoIMCDTO) {
        HistoricoIMC historicoIMC = historicoIMCMapper.toHistoricoIMC(historicoIMCDTO);
        return historicoIMCMapper.toHistoricoIMCDTO(historicoIMCCrudRepository.save(historicoIMC));
    }

    // Actualizar un registro de IMC
    public HistoricoIMCDTO update(HistoricoIMCDTO historicoIMCDTO) {
        HistoricoIMC historicoIMC = historicoIMCMapper.toHistoricoIMC(historicoIMCDTO);
        if (!historicoIMCCrudRepository.existsById(historicoIMC.getId())) {
            throw new IllegalArgumentException("Registro de IMC no encontrado.");
        }
        return historicoIMCMapper.toHistoricoIMCDTO(historicoIMCCrudRepository.save(historicoIMC));
    }

    // Eliminar un registro de IMC por ID
    public void delete(Integer id) {
        if (!historicoIMCCrudRepository.existsById(id)) {
            throw new IllegalArgumentException("Registro de IMC no encontrado.");
        }
        historicoIMCCrudRepository.deleteById(id);
    }

    // Buscar todos los historiales de IMC por ID de usuario
    public List<HistoricoIMCDTO> findByUsuarioId(Integer usuarioId) {
        return historicoIMCCrudRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(historicoIMCMapper::toHistoricoIMCDTO)
                .collect(Collectors.toList());
    }

    // Buscar registros de IMC entre dos fechas
    public List<HistoricoIMCDTO> findByFechaBetween(Timestamp startDate, Timestamp endDate) {
        return historicoIMCCrudRepository.findByFechaBetween(startDate, endDate)
                .stream()
                .map(historicoIMCMapper::toHistoricoIMCDTO)
                .collect(Collectors.toList());
    }

    // Contar los registros de IMC por ID de usuario
    public Long countByUsuarioId(Integer usuarioId) {
        return historicoIMCCrudRepository.countByUsuarioId(usuarioId);
    }

    // Obtener el último registro de IMC por ID de usuario
    public Optional<HistoricoIMCDTO> findLatestByUsuarioId(Integer usuarioId) {
        return historicoIMCCrudRepository.findTopByUsuarioIdOrderByFechaDesc(usuarioId)
                .map(historicoIMCMapper::toHistoricoIMCDTO);
    }
}
