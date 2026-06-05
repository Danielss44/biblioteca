package com.example.biblioteca.repository;

import com.example.biblioteca.infra.entity.Usuario;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    boolean existsByLogin(@NotBlank String login);
}
