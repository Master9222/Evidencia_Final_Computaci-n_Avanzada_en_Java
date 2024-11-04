package com.imc.imc_app.persistence.mapper;

import com.imc.imc_app.persistence.entity.Usuario;
import com.imc.imc_app.domain.dto.UsuarioDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = HistoricoIMCMapper.class) // Asegúrate de incluir el mapper de HistoricoIMC
public interface UsuarioMapper {

    @Mapping(source = "nombreCompleto", target = "nombreCompleto")
    @Mapping(source = "username", target = "username")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "estatura", target = "estatura")
    @Mapping(source = "edad", target = "edad")
    @Mapping(source = "sexo", target = "sexo")
    @Mapping(source = "historicoIMC", target = "historicoIMC") // Mapea la lista de HistoricoIMC
    UsuarioDTO toUsuarioDTO(Usuario usuario);

    @InheritInverseConfiguration
    Usuario toEntity(UsuarioDTO usuarioDTO);
}
