package com.example.biblioteca.repository;

import com.example.biblioteca.infra.entity.Livro;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByTitulo(@NotBlank String titulo);
}
