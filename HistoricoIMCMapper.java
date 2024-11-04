package com.imc.imc_app.persistence.mapper;

import com.imc.imc_app.domain.dto.HistoricoIMCDTO;
import com.imc.imc_app.persistence.entity.HistoricoIMC;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HistoricoIMCMapper {

    @Mapping(source = "usuario.id", target = "usuarioId") // Mapeo del ID del usuario
    @Mapping(source = "imc", target = "imc") // Mapeo del IMC
    @Mapping(source = "fecha", target = "fecha") // Mapeo de la fecha
    HistoricoIMCDTO toHistoricoIMCDTO(HistoricoIMC historicoIMC);

    @InheritInverseConfiguration // Usar la configuración inversa de toHistoricoIMCDTO
    HistoricoIMC toHistoricoIMC(HistoricoIMCDTO historicoIMCDTO);
}
