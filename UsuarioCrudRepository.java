package com.imc.imc_app.persistence.crud;

import com.imc.imc_app.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioCrudRepository extends CrudRepository<Usuario, Integer> {
    // Buscar un usuario por su nombre de usuario
    Usuario findByUsername(String username);

    // Buscar usuarios por nombre completo
    List<Usuario> findByNombreCompleto(String nombreCompleto);

    // Buscar usuarios por edad
    List<Usuario> findByEdad(Integer edad);

    // Contar usuarios por sexo
    Long countBySexo(String sexo);

    // Obtener todos los usuarios, ordenados por nombre completo
    List<Usuario> findAllByOrderByNombreCompletoAsc();

    // Buscar usuarios por sexo
    List<Usuario> findBySexo(String sexo);

    // Buscar un usuario por su nombre de usuario y contraseña
    Usuario findByUsernameAndPassword(String username, String password);
}
