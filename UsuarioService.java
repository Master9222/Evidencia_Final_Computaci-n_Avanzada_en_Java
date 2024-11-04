package com.imc.imc_app.domain.service;

import com.imc.imc_app.domain.dto.UsuarioDTO;
import com.imc.imc_app.persistence.mapper.UsuarioMapper;
import com.imc.imc_app.persistence.entity.Usuario;
import com.imc.imc_app.persistence.entity.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final Argon2PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, Argon2PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public List<UsuarioDTO> findAllUsers() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioMapper::toUsuarioDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioDTO> findUserById(Integer id) {
        return usuarioRepository.findById(id)
                .map(usuarioMapper::toUsuarioDTO);
    }

    public UsuarioDTO createUser(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);  // Cambiado aquí

        // Validar la edad
        if (usuario.getEdad() < 15) {
            throw new IllegalArgumentException("La edad mínima es de 15 años.");
        }

        // Encriptar la contraseña
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);

        Usuario savedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioDTO(savedUsuario);
    }

    public UsuarioDTO updateUser(UsuarioDTO usuarioDTO) {
        if (!usuarioRepository.existsById(usuarioDTO.getId())) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);  // Cambiado aquí
        Usuario updatedUsuario = usuarioRepository.save(usuario);
        return usuarioMapper.toUsuarioDTO(updatedUsuario);
    }

    public void deleteUser(Integer id) {
        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado.");
        }
        usuarioRepository.deleteById(id);
    }

    public Optional<UsuarioDTO> findByUsername(String username) {
        return usuarioRepository.findByUsername(username)
                .map(usuarioMapper::toUsuarioDTO);
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
