package com.example.biblioteca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LivroResponseDTO {
    private Long id;
    private String titulo;
    private String autor;
    private Boolean disp = true;
}
