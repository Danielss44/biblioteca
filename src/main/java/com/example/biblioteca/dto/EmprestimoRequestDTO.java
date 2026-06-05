package com.example.biblioteca.dto;

import com.example.biblioteca.infra.entity.Livro;
import com.example.biblioteca.infra.entity.Usuario;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoRequestDTO {

    private Long usuarioid;

    private Long livroid;
}
