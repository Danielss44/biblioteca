package com.example.biblioteca.dto;

import com.example.biblioteca.infra.entity.Usuario;

import lombok.Getter;

@Getter
public class UsuarioResponseDTO {

    private final Long id;
    private final String login;
    private final String email;

    public UsuarioResponseDTO(Long id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
    }


}
