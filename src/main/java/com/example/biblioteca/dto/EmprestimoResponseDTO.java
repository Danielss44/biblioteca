package com.example.biblioteca.dto;

import com.example.biblioteca.infra.entity.Livro;
import com.example.biblioteca.infra.entity.Usuario;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmprestimoResponseDTO {
    private Long id;

    private LocalDate dataEmprestimo;

    private LocalDate dataDevolucao;

    private Usuario usuario;

    private Livro livro;


    public EmprestimoResponseDTO(Long id, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
