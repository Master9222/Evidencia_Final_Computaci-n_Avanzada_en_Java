package com.imc.imc_app.persistence.entity;

import com.imc.imc_app.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
    // Buscar un usuario por su nombre de usuario
    Optional<Usuario> findByUsername(String username);

    // Contar la cantidad de usuarios
    Long countBy();

    // Buscar todos los usuarios
    List<Usuario> findAll();

    // Buscar usuarios por edad
    List<Usuario> findByEdad(Integer edad);

    // Buscar usuarios por sexo
    List<Usuario> findBySexo(String sexo);

    // Buscar usuarios cuya estatura esté en un rango
    List<Usuario> findByEstaturaBetween(Double minEstatura, Double maxEstatura);

    // Eliminar un usuario por nombre de usuario
    void deleteByUsername(String username);
}
